package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
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
    private final DepressionService depressionService;

    // 일기 조회
    public Diary getDiary(Long id) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return diaryRepository.findById(id)
                .orElseThrow(() -> new DiaryNotFoundException("diary not found"));
    }

    // 회원별 일기 목록 조회
    public List<Diary> getAllDiaries(Long memberId) {
        return diaryRepository.findByMemberId(memberId);
    }

    // 일기 저장
    @Transactional
    public Diary createDiary(Diary diary) {

        // 저장 먼저(영속성 컨텍스에 diary 넣어야 분석 가능)
        Diary saveDiary = diaryRepository.save(diary);

        // 일기 분석
        analyzeDiary(diary);
        return saveDiary;
    }


    // 일기 수정
    @Transactional
    public Diary updateDiary(Long diaryId, String content) {

        // 수정할 일기 찾아옴
        Diary diary = getDiary(diaryId);

        // 일기 내용 수정
        diary.update(content);

        // 일기 분석 다시함
        analyzeDiary(diary);

        return diary;
    }

    // 일기 삭제
    @Transactional
    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }

    // 일기 분석
    //미완
    @Transactional
    public void analyzeDiary(Diary diary) {
        // 우울증 분석 후 연관관계 까지 설정
        Depression depression = depressionService.createDepression(diary);

    }

}
