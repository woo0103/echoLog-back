import whisper
import json
import sys
import os

# ffmpeg 경로 등록
os.environ["PATH"] += os.pathsep + r"C:\Users\playj\Downloads\ffmpeg-7.1.1-essentials_build\ffmpeg-7.1.1-essentials_build\bin"

print("[PY] whisper 모델 로드 시작", file=sys.stderr, flush=True)
model = whisper.load_model("large-v3-turbo")
print("[PY] whisper 모델 로드 완료", file=sys.stderr, flush=True)

while True:
    try:
        print("[PY] 요청 대기 중...", file=sys.stderr, flush=True)

        line = sys.stdin.readline()
        if not line:
            print("[PY] 입력이 종료됨 (EOF)", file=sys.stderr, flush=True)
            break

        input_path = line.strip()
        print(f"[PY] 파일 경로 수신: {input_path}", file=sys.stderr, flush=True)

        result = model.transcribe(input_path)

        output = {
            "content": result["text"]
        }

        print(f"[PY] 변환 완료. 내용 길이: {len(result['text'])}", file=sys.stderr, flush=True)
        print(json.dumps(output, ensure_ascii=False), flush=True)

    except Exception as e:
        print(f"[PY] 오류 발생: {e}", file=sys.stderr, flush=True)
        error_output = {
            "content": "STT 실패",
            "error": str(e)
        }
        print(json.dumps(error_output, ensure_ascii=False), flush=True)