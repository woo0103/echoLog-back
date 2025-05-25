import sys
import json
import warnings
import logging

# 모든 경고 무시
warnings.filterwarnings("ignore")

# transformers 로깅 무시
logging.getLogger("transformers.tokenization_utils_base").setLevel(logging.ERROR)
logging.getLogger("transformers.configuration_utils").setLevel(logging.ERROR)

# 경로 추가
sys.path.append("C:/Users/playj/Desktop/aiData")

from Functions import emo_classify

for line in sys.stdin:
    try:
        data = json.loads(line)
        content = data.get("content", "")
        result = emo_classify(content)
        print(json.dumps({"emotionType": result}, ensure_ascii=False), flush=True)
    except Exception as e:
        print(json.dumps({"error": str(e)}), flush=True)
