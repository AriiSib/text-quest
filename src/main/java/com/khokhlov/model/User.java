package com.khokhlov.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    @Setter
    private String userName;
    private int gameCounter;

    public User() {
        this.gameCounter = 1;
    }

    public int incrementGameCounter() {
        return ++this.gameCounter;
    }
}