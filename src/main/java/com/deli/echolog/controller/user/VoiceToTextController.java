package com.deli.echolog.controller.user;

import com.deli.echolog.dto.VoiceToTextResponseDto;
import com.deli.echolog.service.VoiceToTextService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voice-to-text")
@Slf4j
public class VoiceToTextController {

    private final VoiceToTextService voiceToTextService;

    @PostMapping
    public ResponseEntity<VoiceToTextResponseDto> convert(@RequestParam("file") MultipartFile file) {
        try {
            log.info("🎙음성 파일 수신: {}", file.getOriginalFilename());

            String result = voiceToTextService.convert(file);
            return ResponseEntity.ok(new VoiceToTextResponseDto(result));

        } catch (Exception e) {
            log.error("음성 → 텍스트 변환 실패", e);
            return ResponseEntity.internalServerError().body(new VoiceToTextResponseDto("음성 인식 실패"));
        }
    }

}
