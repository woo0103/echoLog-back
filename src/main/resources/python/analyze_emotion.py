import random
import json
import sys
# 감정 타입 목록
emotion_types = ["ANGRY", "ANXIETY", "EMBARRASSED", "HURT", "JOY", "SAD"]

# 입력 받기 (stdin에서 JSON 읽기)
try:
    input_data = json.load(sys.stdin)
    content = input_data.get("content", "")
except json.JSONDecodeError:
    print(json.dumps({"emotionType": "SAD"}))  # fallback
    sys.exit(1)

# 테스트용: 랜덤 감정 선택
selected_emotion = random.choice(emotion_types)

# 결과 출력 (JSON 형식)
print(json.dumps({
    "emotionType": selected_emotion
}))
