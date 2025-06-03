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

            String pythonPath = "python3";
            String scriptPath = "/home/t25121/transform_content.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(false); // 에러와 출력 스트림 분리

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            log.info("Transform 파이썬 서버 프로세스 시작 완료");

        } catch (IOException e) {
            log.error("Transform 세션 초기화 실패", e);
            throw new RuntimeException("Transform 파이썬 서버 실행 실패", e);
        }
    }

    public static synchronized String transform(String spokenText) throws IOException {
        // JSON 형식으로 전송
        String jsonInput = String.format("{\"content\": \"%s\"}", escapeJson(spokenText));

        writer.write(jsonInput);
        writer.newLine();
        writer.flush();

        String json = reader.readLine();
        log.info("Transform 응답 수신: {}", json);
        return json;
    }

    // JSON 문자열 이스케이프
    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
