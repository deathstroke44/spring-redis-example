package com.techprimers.cache.springredisexample.sevice.redis;

import com.techprimers.cache.springredisexample.model.TableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class RedisMapRepo {
    @Autowired
    private RedisTemplate<String,Long> redisTemplate;
    public Map<String,Long> addTOMap(String tableName, Long status)
    {
        HashOperations<String,String,Long> hashOps=redisTemplate.opsForHash();
        hashOps.put("TableMap",tableName,status);
        return hashOps.entries("TableMap");
    }
    public Map<String,Long> addListTOMap(ArrayList<String> tableList)
    {
        HashOperations<String, String, Long> hashOps = redisTemplate.opsForHash();

        for(String tableName: tableList) {
            hashOps.put("TableMap", tableName, new Long(0));
        }
        return hashOps.entries("TableMap");
    }
    public Long get(String tableName)
    {
        HashOperations<String,String,Long> hashOps=redisTemplate.opsForHash();
        return hashOps.get("TableMap",tableName);

    }
}
