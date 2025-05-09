package com.deli.echolog.service;

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

            // 1. MultipartFile을 temp 파일로 저장
            File tempFile = File.createTempFile("voice", ".wav");
            voiceFile.transferTo(tempFile);

            // 2. 파이썬 실행
            String inputPath = tempFile.getAbsolutePath();
            String resultJson = PythonExecutor.execute("voice_to_text.py", inputPath);
            log.info("파이썬으로부터 받은 결과: {}", resultJson);

            // 3. 파싱 (결과: {"content": "텍스트"})
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
