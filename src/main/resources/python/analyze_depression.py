import json
import random
import sys

# 랜덤 피드백 메시지
feedback_list = [
    "오늘도 잘 버텼어요. 정말 대단해요!",
    "지금까지 해온 것만으로도 충분히 잘하고 있어요.",
    "당신의 마음을 이해해요. 쉬어갈 시간도 필요해요.",
    "스스로를 아껴주세요. 당신은 소중한 사람이에요.",
    "작은 일에도 감사하며 하루를 보내보아요 :)"
]

def analyze(input_json):
    # 입력 파싱
    data = json.loads(input_json)
    content = data.get("content", "")
    emotion_type = data.get("emotionType", "UNKNOWN")

    # 수치 4개 랜덤 생성
    result = {
        "emotionScore": round(random.uniform(0, 10), 2),
        "depressionWordScore": round(random.uniform(0, 10), 2),
        "phq9Score": round(random.uniform(0, 10), 2),
        "gad7Score": round(random.uniform(0, 10), 2),
        "feedback": random.choice(feedback_list)
    }

    print(json.dumps(result, ensure_ascii=False))


if __name__ == "__main__":
    input_json = sys.stdin.read()
    analyze(input_json)
