package com.deli.echolog.python;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class DepressionSession {

    private static Process process;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    static {
        try {
            String pythonPath = "python3";
            String scriptPath = "/home/t25121/v1.0src/ai/analyze_depression.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(false);

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            log.info("Depression 파이썬 서버 프로세스 시작 완료");

        } catch (IOException e) {
            log.error("Depression 세션 초기화 실패", e);
            throw new RuntimeException("Depression 파이썬 서버 실행 실패", e);
        }
    }

    public static synchronized String analyze(String jsonInput) throws IOException {
        writer.write(jsonInput);
        writer.newLine();
        writer.flush();

        String jsonOutput = reader.readLine();
        log.info(" Depression 응답 수신: {}", jsonOutput);
        return jsonOutput;
    }
}

