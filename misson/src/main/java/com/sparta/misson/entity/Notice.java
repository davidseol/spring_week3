package com.sparta.misson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.misson.entity.Timestamped;
import com.sparta.misson.dto.NoticeRequestDto;
import com.sparta.misson.dto.ResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Setter

public class Notice extends Timestamped {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String content;

    public Notice(String title, String name, String pass, String content) {
        this.title = title;
        this.name = name;
        this.pass = pass;
        this.content = content;
    }
    public Notice(NoticeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.pass = requestDto.getPass();
        this.content = requestDto.getContent();
    }

    public void update(NoticeRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.pass = requestDto.getPass();
        this.content = requestDto.getContent();
    }
    public ResponseDto noticeDto() {
        return new ResponseDto(this.title, this.content);
    }
}
