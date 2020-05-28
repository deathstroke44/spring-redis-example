package com.techprimers.cache.springredisexample;

import com.techprimers.cache.springredisexample.model.ID;
import com.techprimers.cache.springredisexample.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private RedisTemplate<ID, User> redisTemplate;

    private HashOperations hashOperations;


    public UserRepositoryImpl(RedisTemplate<ID, User> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<ID, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(ID id) {
        return (User)hashOperations.get("USER", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(ID id) {

        hashOperations.delete("USER", id);
    }
}
