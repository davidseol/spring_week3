package com.sparta.misson.controller;

import com.sparta.misson.dto.NoticeRequestDto;
import com.sparta.misson.dto.ResponseDto;
import com.sparta.misson.entity.Notice;
import com.sparta.misson.repository.NoticeRepository;
import com.sparta.misson.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController

public class NoticeController {
    private final NoticeRepository noticeRepository;
    private final NoticeService noticeService;


    @GetMapping("/api/notices")
    public List<ResponseDto> findNotice() {
        return noticeService.readNotices();
    }

    @PostMapping("/api/notices")
    public Notice createNotice(@RequestBody NoticeRequestDto requestDto) {
        Notice notice = new Notice(requestDto);
        return noticeRepository.save(notice);
    }
    @GetMapping("/api/notices/{id}")
    public Optional<Notice> getNotices(@PathVariable Long id) {
        return noticeRepository.findById(id);
    }
    @PostMapping("/api/notices/{id}")
    public boolean checkPassword(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto) {
        return noticeService.checkPassword(id, requestDto.getPass());
    }

    @PutMapping("/api/notices/{id}")
    public Long updateNotice(@PathVariable Long id, @RequestBody NoticeRequestDto requestDto) {
        noticeService.update(id, requestDto);
        return id;
    }
    @DeleteMapping("/api/notices/{id}")
    public Long deleteNotice(@PathVariable Long id) {
        noticeRepository.deleteById(id);
        return id;
    }
}