package com.deli.echolog.service;

import com.deli.echolog.python.WhisperSession;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class VoiceToTextService {

    private final ObjectMapper objectMapper;

    public String convert(MultipartFile voiceFile) {
        try {
            // 1. MultipartFile을 임시 파일로 저장
            File tempFile = File.createTempFile("voice", ".wav");
            voiceFile.transferTo(tempFile);

            // 2. WhisperSession을 통해 텍스트 추출 (whisper 서버는 모델 재사용 중!)
            String resultJson = WhisperSession.transcribe(tempFile.getAbsolutePath());
            log.info("Whisper 결과 수신: {}", resultJson);

            // 3. 결과 파싱
            Map<String, Object> result = objectMapper.readValue(resultJson, new TypeReference<>() {});
            Object content = result.get("content");
            if (content == null) {
                throw new RuntimeException("결과 JSON에 'content' 키가 없음");
            }

            return content.toString();

        } catch (Exception e) {
            log.error("음성 → 텍스트 변환 실패", e);
            throw new RuntimeException("STT 변환 중 예외 발생", e);
        }
    }
}
