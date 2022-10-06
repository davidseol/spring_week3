package com.sparta.misson.dto;

import com.sparta.misson.entity.Notice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

public class ResponseDto {
    private String title;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;



    public ResponseDto(String title, String name) {
        this.title = title;
        this.name = name;

    }

    public ResponseDto(Notice notice) {
        this.title = notice.getTitle();
        this.name = notice.getName();
        this.createdAt = notice.getCreatedAt();
        this.modifiedAt = notice.getModifiedAt();

    }

}
