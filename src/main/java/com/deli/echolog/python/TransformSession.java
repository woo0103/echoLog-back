package com.deli.echolog.python;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class TransformSession {

    private static Process process;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    static {
        try {
            String pythonPath = "C:\\Users\\playj\\AppData\\Local\\Programs\\Python\\Python39\\python.exe";
            String scriptPath = "C:\\Users\\playj\\Desktop\\transform_content.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(true); // stderr 통합

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            log.info("✅ Transform 파이썬 서버 프로세스 시작 완료");

        } catch (IOException e) {
            log.error("❌ Transform 세션 초기화 실패", e);
            throw new RuntimeException("Transform 파이썬 서버 실행 실패", e);
        }
    }

    public static synchronized String transform(String spokenText) throws IOException {
        String jsonInput = String.format("{\"content\": \"%s\"}", escapeJson(spokenText));

        writer.write(jsonInput);
        writer.newLine();
        writer.flush();

        String json = reader.readLine();
        if (json == null || json.trim().isEmpty()) {
            log.error("📛 파이썬 응답이 null 또는 빈 문자열입니다. 변환 실패");
            throw new IOException("파이썬 응답 없음 (null)");
        }

        log.info("📤 Transform 응답 수신: {}", json);
        return json;
    }

    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
