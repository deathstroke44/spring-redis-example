package com.redis.cache.ntmc_redis.model;

import java.io.Serializable;

public class ID implements Serializable
{
    String eiin;
    String boardName;

    public ID(String eiin, String boardName) {
        this.eiin = eiin;
        this.boardName = boardName;
    }

    public ID() {
    }

    public String getEiin() {
        return eiin;
    }

    public void setEiin(String eiin) {
        this.eiin = eiin;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
}
