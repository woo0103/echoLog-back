import json
import random
import sys

responses = [
    "정말 흥미로운 이야기네요!",
    "그렇군요, 계속 들려주세요.",
   "감정이 느껴지는 말이네요.",
      "좋은 하루 되세요!",
    "음... 생각해볼 만한 이야기예요."
]

# 랜덤 선택
result = {
    "content": random.choice(responses)
}

# JSON으로 출력
print(json.dumps(result, ensure_ascii=False))
