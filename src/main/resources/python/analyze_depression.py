import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'  # TensorFlow 로그 감춤

import sys
import json
import warnings
import logging

warnings.filterwarnings("ignore")
logging.getLogger("transformers.tokenization_utils_base").setLevel(logging.ERROR)
logging.getLogger("transformers.configuration_utils").setLevel(logging.ERROR)

sys.path.append("/home/t25121/aidata")
from Functions import diagnosis_melancholia

for line in sys.stdin:
    try:
        data = json.loads(line)
        items = data.get("items", [])

        if not items:
            print(json.dumps({"error": "empty input"}), flush=True)
            continue

        # 마지막 일기 하나로 emoScore, depressionScore 계산
        last = items[-1]
        last_emotion = last.get("emotion", "SAD")
        last_log = last.get("log", "")

        emo_score, depression_score, _, _ = diagnosis_melancholia(last_emotion, last_log)

        #  전체 14일치로 phq/gad 누적 계산
        total_phq9_score = 0
        total_gad7_score = 0

        for item in items:
            emotion = item.get("emotion", "SAD")  # 감정은 필요 없지만 함수 시그니처상 넘김
            log = item.get("log", "")
            _, _, phq9, gad7 = diagnosis_melancholia(emotion, log)
            total_phq9_score += sum(phq9)
            total_gad7_score += sum(gad7)

        result = {
            "emoScore": emo_score,
            "depressionWordScore": round(depression_score, 2),
            "phq9Score": total_phq9_score,
            "gad7Score": total_gad7_score
        }

        print(json.dumps({"result": result}, ensure_ascii=False), flush=True)

    except Exception as e:
        print(json.dumps({"error": str(e)}), flush=True)
