package com.gorob.simplified.dance.notation.model.dance;

import lombok.Getter;

@Getter
public enum MediaService {
    YOUTUBE("Youtube"),
    AMAZON_MUSIC("Amazon Music");

    private String name;

    MediaService(String name){
        this.name = name;
    }
}
