package com.student.management.MAINET10.CommonUtil;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MdmsService {

    private final StringRedisTemplate redisTemplate;

    public MdmsService(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    // 1. STORE (SET) with TTL (Time-To-Live)
    public void cacheMdmsData(String meterId, String payload){
        redisTemplate.opsForValue().set("mdms:" + meterId, payload, Duration.ofMinutes(30));
    }

    // 2. READ (GET)
    public String getCachedMdmsData(String meterId) {
        return redisTemplate.opsForValue().get("mdms:" + meterId);
    }

    // 3. DELETE (DEL)
    public void removeCachedData(String meterId) {
        redisTemplate.delete("mdms:" + meterId);
    }

    // 4. ATOMIC INCREMENT (Useful for real-time consumption aggregations)
    public Long incrementUnits(String meterId, long units) {
        return redisTemplate.opsForValue().increment("mdms:units:" + meterId, units);
    }
}
