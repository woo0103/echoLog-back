package com.deli.echolog.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Repository
public class RecapRepository {

    private final EntityManager em;

    public List<Object[]> countEmotionTypesBetween(LocalDate fromDate, LocalDate toDate) {
        return em.createQuery("""
            SELECT e.emotionType, COUNT(e)
            FROM Emotion e
            JOIN e.diary d
            WHERE d.writtenDate >= :fromDate AND d.writtenDate <= :toDate
            GROUP BY e.emotionType
            ORDER BY e.emotionType
        """, Object[].class)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
    }



}
