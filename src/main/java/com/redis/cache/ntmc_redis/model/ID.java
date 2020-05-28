package com.redis.cache.ntmc_redis.model;

import java.io.Serializable;

public class ID implements Serializable
{
    String roll;
    String level;

    public ID(String roll, String level) {
        this.roll = roll;
        this.level = level;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
