import json
import random
import sys

# 랜덤 피드백 메시지
feedback_list = [

    "당신은 지금 스스로를 바라보고, 조용히 들여다보고 있어요. 그건 이미 잘 버티고 있다는 증거입니다. 그냥 떠나고 싶다는 말이 나왔다는 건, 도망치고 싶다는 게 아니라, 잠시 쉬고 싶다는 마음일지도 몰라요."

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
        "phq9Score": round(random.uniform(15, 27), 2),
        "gad7Score": round(random.uniform(15, 21), 2),
        "feedback": random.choice(feedback_list)
    }

    print(json.dumps(result, ensure_ascii=False))


if __name__ == "__main__":
    input_json = sys.stdin.read()
    analyze(input_json)
