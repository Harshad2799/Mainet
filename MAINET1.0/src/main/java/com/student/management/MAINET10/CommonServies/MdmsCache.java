package com.student.management.MAINET10.CommonServies;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MdmsCache {

    private static final Map<String, Object> CACHE = new ConcurrentHashMap<>();

    private MdmsCache() {
    }

    public static void put(String key, Object value) {
        CACHE.put(key, value);
    }

    public static Object get(String key) {
        return CACHE.get(key);
    }

    public static Map<String, Object> getAll() {
        return CACHE;
    }

}
