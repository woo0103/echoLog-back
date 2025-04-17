package com.deli.echolog.repository;

import com.deli.echolog.domain.TransformDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformDiaryRepository extends JpaRepository<TransformDiary, Long> {

}
