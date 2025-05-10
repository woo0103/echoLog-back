package com.deli.echolog.repository;

import com.deli.echolog.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    // 모든 일기 목록 조회
    List<Diary> findByMemberId(Long memberId);

    // 일기 월별로 조회
    List<Diary> findByMemberIdAndWrittenDateBetween(Long memberId, LocalDate startDate, LocalDate endDate);

    // 일기 날짜로 조회
    Diary findByWrittenDateAndMemberId(LocalDate written, Long memberId);



}
