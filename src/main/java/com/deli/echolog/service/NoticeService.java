package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.domain.Notice;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.repository.NoticeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class NoticeService {

    private final NoticeRepository noticeRepository;

    // 공지사항 조회
    @Transactional(readOnly = true)
    public Notice getNotice(Long noticeId) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return noticeRepository.findById(noticeId)
                .orElseThrow(() -> new DepressionNotFoundException("notice not found"));
    }



    // 공지사항 저장
    public Notice saveNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // 공지사항 수정
    public Notice updateNotice(Long noticeId, String title, String content, String writer) {
        Notice notice = getNotice(noticeId);
        notice.update(title, content, writer);
        return notice;
    }

    // 공지사항 삭제
    public void deleteNotice(Long noticeId) {
        Notice notice = getNotice(noticeId);
        noticeRepository.delete(notice);
    }
}
