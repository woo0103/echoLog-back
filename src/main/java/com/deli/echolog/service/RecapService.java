package com.deli.echolog.service;

import com.deli.echolog.repository.RecapRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecapService {

    private final RecapRepository recapRepository;

    public Map<String, Long> getEmotionRecap() {
        LocalDate fromDate = LocalDate.now().minusDays(13); // 오늘 포함해서 14일치

        List<Object[]> raw = recapRepository.countEmotionTypesBetween(fromDate, LocalDate.now());

        // Object[] -> Map<String, Long> 변환 (정렬 포함)
        return raw.stream()
                .collect(Collectors.toMap(
                        row -> row[0].toString(),     // EmotionType (enum → String)
                        row -> (Long) row[1],         // count
                        (v1, v2) -> v1,
                        LinkedHashMap::new            // 정렬 유지 (ORDER BY emotionType)
                ));
    }
}
