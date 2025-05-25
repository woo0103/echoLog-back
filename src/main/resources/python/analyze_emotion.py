import aidata.Functions as func
import json
import sys

while True:
    try:
        line = sys.stdin.readline()
        if not line:
            break

        input_json = json.loads(line)
        prompt = input_json.get("content", "").strip()
        print(func.emo_classify(prompt))

    except Exception:
        print(json.dumps({
            "analysis": "분석 실패",
            "error": "예외 발생"
        }, ensure_ascii=False), flush=True)