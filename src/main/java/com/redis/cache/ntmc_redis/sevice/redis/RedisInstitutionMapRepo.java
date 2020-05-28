package com.redis.cache.ntmc_redis.sevice.redis;

import com.redis.cache.ntmc_redis.model.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisInstitutionMapRepo {
    @Autowired
    private RedisTemplate<ID,Map> redisTemplate;
    public Map<ID,Map> addTOMap(ID id, Map map)
    {
        HashOperations hashOps=redisTemplate.opsForHash();
        hashOps.put("InstitutionMap",id,map);
        return hashOps.entries("InstitutionMap");
    }
    public Map get(ID id)
    {
        HashOperations hashOps=redisTemplate.opsForHash();
        return (Map)hashOps.get("InstitutionMap",id);

    }
}
