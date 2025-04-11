package com.deli.echolog.repository;

import com.deli.echolog.domain.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    // 일기 목록 조회
    List<Diary> findByMemberId(Long memberId);
}
