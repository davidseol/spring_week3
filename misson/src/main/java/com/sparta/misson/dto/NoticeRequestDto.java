package com.sparta.misson.dto;

import lombok.Getter;



@Getter

public class NoticeRequestDto {
    private String title;
    private String name;
    private String pass;
    private String content;

    public NoticeRequestDto(String title, String name, String pass, String content) {
        this.title = title;
        this.name = name;
        this.pass = pass;
        this.content = content;
    }
}

