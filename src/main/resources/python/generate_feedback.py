import sys
import json
import warnings
import logging
import os

# 모든 경고 무시
warnings.filterwarnings("ignore")

# HuggingFace 관련 로그 무시
logging.getLogger("transformers.tokenization_utils_base").setLevel(logging.ERROR)
logging.getLogger("transformers.configuration_utils").setLevel(logging.ERROR)

# TensorFlow 관련 로그 무시
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'  # '3' = FATAL

# Functions.py 경로 추가
sys.path.append("/home/t25121/aidata")

from Functions import create_feedback

for line in sys.stdin:
    try:
        data = json.loads(line)
        emotion = data.get("emotion", "SAD")
        log = data.get("log", "")

        result = create_feedback(emotion, log)
        print(json.dumps({"feedback": result}, ensure_ascii=False), flush=True)

    except Exception as e:
        print(json.dumps({"error": str(e)}), flush=True)
