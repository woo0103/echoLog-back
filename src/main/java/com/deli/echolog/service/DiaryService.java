package com.deli.echolog.service;

import com.deli.echolog.domain.*;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.repository.DiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

    // 생성자 주입
    private final MemberService memberService;
    private final DiaryRepository diaryRepository;
    private final TransformDiaryService transformDiaryService;
    private final EmotionService emotionService;
    private final DiaryFeedbackService diaryFeedbackService;
    private final DepressionService depressionService;

    // 일기 조회
    public Diary getDiary(Long diaryId) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return diaryRepository.findById(diaryId)
                .orElseThrow(() -> new DiaryNotFoundException("diary not found"));
    }

    // 날짜로 일기 조회
    public Diary getDiaryByWrittenDate(LocalDate writtenDate, Long memberId) {
        return diaryRepository.findByWrittenDateAndMemberId(writtenDate, memberId);
    }

    // transformDiaryId로 일기 조회
    public Diary getDiaryByTransformDiaryId(Long transformDiaryId) {
        return diaryRepository.findByTransformDiaryId(transformDiaryId);
    }

    // 회원별 일기 목록 조회
    public List<Diary> getAllDiaries(Long memberId) {
        return diaryRepository.findByMemberId(memberId);
    }

    // 회원별 일기 월별 조회
    public List<Diary> getDiariesByMonth(Long memberId, int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return diaryRepository.findByMemberIdAndWrittenDateBetween(memberId, start, end);
    }

    // 회원별 일기 14일치 조회
    public List<Diary> getDiariesBy2weeks(Long memberId, LocalDate writtenDate) {
        LocalDate start = writtenDate.minusDays(13);
        LocalDate end = writtenDate;
        return diaryRepository.findByMemberIdAndWrittenDateBetween(memberId, start, end);
    }

    // 일기 저장
    // 저장 기능만 하니까 save로 함
    @Transactional
    public Diary saveDiary(Diary diary) {

        // 저장 먼저(영속성 컨텍스에 diary 넣어야 분석 가능)
        return diaryRepository.save(diary);
    }




    // 일기 생성
    /**
     * 일기 내용 분석 후 연관관계까지 설정해서 반환하는 메서드임
     * @param temp 임시저장여부
     * @param memberId 일기 쓴 회원 아이디
     * @param content 일기 내용
     * @return 생성된 일기
     */
    @Transactional
    public Diary createDiary(boolean temp, Long memberId, String content, LocalDate writtenDate) {
        // 회원 찾아옴
        Member member = memberService.getMember(memberId);
        // 작성하는 날짜에 이미 일기가 있는지 확인함
        Diary diaryByWrittenDate = getDiaryByWrittenDate(writtenDate, memberId);
        // 있으면 삭제 후 생성
        if (diaryByWrittenDate != null) {
            deleteDiary(diaryByWrittenDate.getId());
        }


        // 일기 내용 저장
        Diary diary = new Diary(content,writtenDate);
        // 연관관계 설정하기 전에 일기 영속성 컨텍스트에 넣음
        saveDiary(diary);
        // member랑 연관관계 설정
        diary.setMember(member);

        // 임시 저장이 아니면 분석 진행
        if (!temp) {
            analyzeDiary(diary);
        }

        return diary;
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
    public void deleteDiary(Long diaryId) {
        diaryRepository.deleteById(diaryId);
    }

    // 일기 분석
    //미완
    @Transactional
    public void analyzeDiary(Diary diary) {
        // 분석 후 연관관계까지 설정
        TransformDiary transformDiary = transformDiaryService.transform(diary);
        Emotion emotion = emotionService.analyzeEmotion(diary);
        DiaryFeedback diaryFeedback = diaryFeedbackService.generateFeedback(diary);
        Depression depression = depressionService.analyzeDepression(diary);
    }
    
    @Transactional
    public void analyzeDiary(Diary diary, TransformDiary transformDiary) {
        // 분석 후 연관관계까지 설정
        Emotion emotion = emotionService.analyzeEmotion(diary);
        DiaryFeedback diaryFeedback = diaryFeedbackService.generateFeedback(diary);
        Depression depression = depressionService.analyzeDepression(diary);

        diary.changeTransformDiary(transformDiary);
    }

}
