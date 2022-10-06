package com.sparta.misson;

import com.sparta.misson.dto.NoticeRequestDto;
import com.sparta.misson.entity.Notice;
import com.sparta.misson.repository.NoticeRepository;
import com.sparta.misson.service.NoticeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class MissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MissonApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(NoticeRepository noticeRepository, NoticeService noticeService) {
        return (args) -> {
            noticeRepository.save(new Notice("스프링이란","설창환", "12345", "여기는 컨텐츠 적는곳"));

            System.out.println("게시글 등록");
            List<Notice> noticeList = noticeRepository.findAll();
            for (int i=0; i<noticeList.size(); i++) {
                Notice notice = noticeList.get(i);
                System.out.println(notice.getId());
                System.out.println(notice.getTitle());
                System.out.println(notice.getName());
                System.out.println(notice.getPass());
                System.out.println(notice.getContent());
            }

            NoticeRequestDto requestDto = new NoticeRequestDto("파이썬이란", "박창식", "12345", "여기는 전쟁터");
            noticeService.update(1L, requestDto);
            noticeList = noticeRepository.findAll();
            for (int i=0; i<noticeList.size(); i++) {
                Notice notice = noticeList.get(i);
                System.out.println(notice.getId());
                System.out.println(notice.getTitle());
                System.out.println(notice.getName());
                System.out.println(notice.getPass());
                System.out.println(notice.getContent());

            }

//            noticeRepository.deleteAll();
        };
    }

}
