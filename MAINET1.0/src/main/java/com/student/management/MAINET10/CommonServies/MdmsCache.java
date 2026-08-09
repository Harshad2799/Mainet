package com.student.management.MAINET10.CommonServies;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MdmsCache {

    private static final String HASH_KEY = "mdms:data";

    private final HashOperations<String, String, Object> hashOps;

    public MdmsCache(RedisTemplate<String, Object> redisTemplate) {
        this.hashOps = redisTemplate.opsForHash();
    }

    public void put(String key, Object value) {
        hashOps.put(HASH_KEY, key, value);
    }

    public Object get(String key) {
        return hashOps.get(HASH_KEY, key);
    }

    public Map<String, Object> getAll() {
        return hashOps.entries(HASH_KEY);
    }
}
