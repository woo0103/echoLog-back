package com.deli.echolog.controller.recap;

import com.deli.echolog.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/recap")
@RequiredArgsConstructor
public class RecapController {

    private final com.deli.echolog.service.RecapService recapService;

    @GetMapping("/emotion")
    public ResponseEntity<Map<String, Long>> getEmotionRecap() {
        Long loginMemberId = AuthUtil.getLoginMemberId();
        Map<String, Long> emotionStats = recapService.getEmotionRecap(loginMemberId);
        return ResponseEntity.ok(emotionStats);
    }

}
