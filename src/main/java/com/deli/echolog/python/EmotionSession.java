package com.deli.echolog.python;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class EmotionSession {

    private static Process process;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    static {
        try {
            // 서버 환경에 맞춘 경로
            String pythonPath = "python3";
            String scriptPath = "/home/t25121/v1.0src/ai/analyze_emotion.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(false); // stderr와 stdout 분리

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            log.info("Emotion 파이썬 서버 프로세스 시작 완료");

        } catch (IOException e) {
            log.error("Emotion 세션 초기화 실패", e);
            throw new RuntimeException("Emotion 파이썬 서버 실행 실패", e);
        }
    }

    public static synchronized String analyze(String sentence) throws IOException {
        String jsonInput = String.format("{\"content\": \"%s\"}", escapeJson(sentence));

        writer.write(jsonInput);
        writer.newLine();
        writer.flush();

        String json = reader.readLine();
        log.info("Emotion 응답 수신: {}", json);
        return json;
    }

    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
