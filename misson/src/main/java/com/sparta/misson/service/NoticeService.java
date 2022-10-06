package com.sparta.misson.service;

import com.sparta.misson.dto.NoticeRequestDto;
import com.sparta.misson.dto.ResponseDto;
import com.sparta.misson.entity.Notice;
import com.sparta.misson.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;


    @Transactional
    public List<ResponseDto> readNotices() {
        List<Notice> notices = this.noticeRepository.findAllByOrderByModifiedAtDesc();
        List<ResponseDto> responseDtos = new ArrayList<>();

        for (int i = 0; i < notices.toArray().length; i++) {

            ResponseDto temp = new ResponseDto(notices.get(i));
            responseDtos.add(temp);
        }

        return responseDtos;
    }
    public Notice notice(NoticeRequestDto requestDto) {
        Notice notice = new Notice(requestDto);
        noticeRepository.save(notice);
        return notice;
    }
    @Transactional
    public Long update(Long id, NoticeRequestDto requestDto) {
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        notice.update(requestDto);
        return notice.getId();
    }
    public Long deleteNoticeId(Long id) {
        noticeRepository.deleteById(id);
        return id;
    }
    public boolean checkPassword(Long id, String pass) {
        Notice notice = noticeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        String check = notice.getPass();
        return check.equals(pass);
    }
}