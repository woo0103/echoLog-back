import json
import whisper
import sys
import os

os.environ["PATH"] += os.pathsep + "C:\\Users\\playj\\Downloads\\ffmpeg-7.1.1-essentials_build\\ffmpeg-7.1.1-essentials_build\\bin"

# 1. Python 실행 시 전달된 인자 사용
# ex) sys.argv[1] → Java에서 실행할 때 파일 경로 넘기기
inputPath = sys.argv[1]

model = whisper.load_model("large-v3-turbo")  # 팀원이 만든 모델이면 따로 잘 들어있는지 확인
data = model.transcribe(inputPath)

result = {
    "content": data["text"]
}

print(json.dumps(result, ensure_ascii=False))