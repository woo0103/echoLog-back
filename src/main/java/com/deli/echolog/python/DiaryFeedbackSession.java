package com.deli.echolog.python;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class DiaryFeedbackSession {

    private static Process process;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    static {
        try {
            String pythonPath = "python3";
            String scriptPath = "/home/t25121/v1.0src/ai/generate_feedback.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(true);

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            log.info("DiaryFeedback 파이썬 프로세스 시작 완료");

        } catch (IOException e) {
            log.error("DiaryFeedbackSession 초기화 실패", e);
            throw new RuntimeException("피드백 파이썬 실행 실패", e);
        }
    }

    public static synchronized String analyze(String emotionType, String content) throws IOException {
        String jsonInput = String.format("{\"emotion\": \"%s\", \"log\": \"%s\"}",
                escapeJson(emotionType), escapeJson(content));

        writer.write(jsonInput);
        writer.newLine();
        writer.flush();

        String json = reader.readLine();
        log.info("DiaryFeedback 응답 수신: {}", json);
        return json;
    }

    private static String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
