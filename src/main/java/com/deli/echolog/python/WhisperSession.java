package com.deli.echolog.python;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class WhisperSession {

    private static Process process;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    static {
        try {
            String pythonPath = "C:\\Users\\playj\\AppData\\Local\\Programs\\Python\\Python310\\python.exe";
            String scriptPath = "C:\\Users\\playj\\Desktop\\voice_to_text.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(false); // 에러와 출력 스트림 분리

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            log.info("✅ Whisper 파이썬 서버 프로세스 시작 완료");

        } catch (IOException e) {
            log.error("❌ Whisper 세션 초기화 실패", e);
            throw new RuntimeException("Whisper 파이썬 서버 실행 실패", e);
        }
    }

    public static synchronized String transcribe(String wavPath) throws IOException {
        writer.write(wavPath);
        writer.newLine();
        writer.flush();

        String json = reader.readLine();
        log.info("📤 Whisper 응답 수신: {}", json);
        return json;
    }
}
