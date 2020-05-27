package com.techprimers.cache.springredisexample;

import com.techprimers.cache.springredisexample.model.ID;
import com.techprimers.cache.springredisexample.model.User;

import java.util.Map;

public interface UserRepository {

    void save(User user);
    Map<ID, User> findAll();
    User findById(ID id);
    void update(User user);
    void delete(ID id);
}
