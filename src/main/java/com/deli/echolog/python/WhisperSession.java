package com.deli.echolog.python;

import java.io.*;

public class WhisperSession {

    private static Process process;
    private static BufferedWriter writer;
    private static BufferedReader reader;

    static {
        try {
            String pythonPath = "python3"; // 리눅스 환경용
            String scriptPath = "/home/t25121/v1.0src/ai/voice_to_text.py";

            ProcessBuilder builder = new ProcessBuilder(pythonPath, scriptPath);
            builder.environment().put("PYTHONIOENCODING", "utf-8");
            builder.redirectErrorStream(true); // 로그 병합

            process = builder.start();

            writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException("Whisper 파이썬 서버 실행 실패", e);
        }
    }

    public static synchronized String transcribe(String wavPath) throws IOException {
        writer.write(wavPath);
        writer.newLine();
        writer.flush();

        return reader.readLine(); // JSON 1줄만 반환
    }
}
