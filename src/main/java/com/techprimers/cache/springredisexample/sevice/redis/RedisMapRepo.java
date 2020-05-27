package com.techprimers.cache.springredisexample.sevice.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class RedisMapRepo {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    public Map<String,String> addTOMap(String tableName, Long status)
    {
        HashOperations<String,String,String> hashOps=redisTemplate.opsForHash();
        hashOps.put("TableMap",tableName,Long.toString(status));
        return hashOps.entries("TableMap");
    }
    public String get(String tableName)
    {
        HashOperations<String,String,String> hashOps=redisTemplate.opsForHash();
        return hashOps.get("TableMap",tableName);

    }
}
