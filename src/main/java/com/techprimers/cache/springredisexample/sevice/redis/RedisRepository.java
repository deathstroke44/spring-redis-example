package com.techprimers.cache.springredisexample.sevice.redis;

import java.util.ArrayList;
import java.util.List;

public interface RedisRepository {
    Long addToList(String key, List<String> list);
    Long listSize(String key);
    String getLeftItem(String key);
    void deleteKey(String key);
}
