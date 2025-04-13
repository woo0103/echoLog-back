package com.deli.echolog.service;

import com.deli.echolog.domain.Depression;
import com.deli.echolog.domain.Diary;
import com.deli.echolog.exception.DepressionNotFoundException;
import com.deli.echolog.exception.DiaryNotFoundException;
import com.deli.echolog.repository.DepressionRepository;
import com.deli.echolog.repository.DiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DepressionService {

    private final DepressionRepository depressionRepository;
    private final DiaryService diaryService;

    // 우울증 분석 조회
    public Depression getDepression(Long id) {
        // id에 해당하는 일기가 없으면 예외 던짐
        return depressionRepository.findById(id)
                .orElseThrow(() -> new DepressionNotFoundException("depression not found"));
    }

    // 우울증 분석 결과 저장
    public Depression createDepression(Long diaryId) {
        Depression depression = analyzeDepression(diaryId);
        return depressionRepository.save(depression);
    }

    // 우울증 분석 메서드
    // 일기 정보를 받아서 우울증
    public Depression analyzeDepression(Long diaryId) {
        Diary diary = diaryService.getDiary(diaryId);
        // AI 연결해서 분석하는 로직
        // AI가 반환했다고 침
        Depression depression = new Depression();
        diary.changeDepression(depression);
        return depression;
    }
}
