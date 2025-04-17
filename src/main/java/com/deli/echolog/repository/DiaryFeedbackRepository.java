package com.deli.echolog.repository;

import com.deli.echolog.domain.DiaryFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryFeedbackRepository extends JpaRepository<DiaryFeedback, Long> {

}
