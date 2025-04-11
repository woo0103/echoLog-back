package com.deli.echolog.service;

import com.deli.echolog.domain.Diary;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.repository.DiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

    // 생성자 주입
    private final DiaryRepository diaryRepository;


    // 일기 저장
    @Transactional
    public Diary createDiary(Diary diary) {
        // AI 분석 추가 해야함
        return diaryRepository.save(diary);
    }

    // 일기 조회
    public Diary getDiary(Long id) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return diaryRepository.findById(id)
                .orElseThrow(() -> new DiaryNotFoundException("diary not found"));
    }

    // 일기 목록 조회
    public List<Diary> getAllDiaries(Long memberId) {
        return diaryRepository.findByMemberId(memberId);
    }

    // 일기 수정
    @Transactional
    public Diary updateDiary(Diary diary) {
        // 수정할 일기 찾아옴
        Diary originDiary = diaryRepository.findById(diary.getId())
                .orElseThrow(() -> new DiaryNotFoundException("diary not found"));

        // 일기 내용 수정
        originDiary.update(diary.getContent());


        return originDiary;
    }

    // 일기 삭제
    @Transactional
    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }



}
