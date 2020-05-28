package com.redis.cache.ntmc_redis.model;

import java.util.Map;

public class MapObject {
    Map map;

    public MapObject(Map map) {
        this.map = map;
    }

    public MapObject() {
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
