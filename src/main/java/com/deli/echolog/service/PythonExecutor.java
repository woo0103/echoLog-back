package com.deli.echolog.service;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class PythonExecutor {

    /**
     * 파이썬 스크립트를 실행하고 결과를 문자열로 반환
     *
     * @param scriptName 실행할 파이썬 파일 이름 (resources/python 디렉토리에 위치)
     * @param input  파이썬으로 전달할 JSON 문자열
     * @return 파이썬에서 반환한 stdout 문자열
     */
    public static String execute(String scriptName, String input) throws IOException, InterruptedException {
        File scriptFile = extractPythonScript(scriptName);

        ProcessBuilder builder = new ProcessBuilder("python", scriptFile.getAbsolutePath());
        builder.environment().put("PYTHONIOENCODING", "utf-8");

        Process process = builder.start();

        // stdin으로 JSON 전달
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
            writer.write(input);
            writer.flush();
        }

        // stdout 읽기
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        }

        // stderr 로깅
        try (BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String errLine;
            while ((errLine = errReader.readLine()) != null) {
                log.error("파이썬 stderr: {}", errLine);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("파이썬 실행 실패 (exitCode=" + exitCode + ")");
        }

        return output.toString();
    }

    /**
     * resources/python 디렉토리의 파이썬 파일을 임시 파일로 추출
     */
    private static File extractPythonScript(String name) throws IOException {
        String resourcePath = "python/" + name;
        InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
        if (input == null) {
            throw new FileNotFoundException("리소스 파일을 찾을 수 없음: " + resourcePath);
        }

        File tempFile = File.createTempFile("script-", ".py");
        tempFile.deleteOnExit();

        try (OutputStream out = new FileOutputStream(tempFile)) {
            input.transferTo(out);
        }

        return tempFile;
    }
}