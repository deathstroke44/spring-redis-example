package com.techprimers.cache.springredisexample.sevice.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisClusterRepository implements RedisRepository{
    private static final Logger logger = LoggerFactory.getLogger(RedisClusterRepository.class);

    @Autowired
    private StringRedisTemplate redisTemplate;
//    private RedisTemplate<String, Object> redisTemplate;





    @Override
    public Long addToList(String key, List<String> list) {
        return redisTemplate.opsForList().rightPushAll(key, list.stream().toArray(String[]::new));
    }

    @Override
    public Long listSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public String getLeftItem(String key) {
        return (String) redisTemplate.opsForList().leftPop(key);
    }

    @Override
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }
}
