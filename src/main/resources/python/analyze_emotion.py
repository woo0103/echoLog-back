import sys, os, json

# 경로 추가 (절대 경로)
sys.path.append("C:/Users/playj/Desktop/aiData")

from Functions import emo_classify

print("📥 Python 시작됨", flush=True)

for line in sys.stdin:
    print("📥 입력 수신됨:", line, flush=True)
    try:
        data = json.loads(line)
        content = data.get("content", "")
        result = emo_classify(content)
        print(json.dumps({"emotion": result}, ensure_ascii=False), flush=True)  # 🔥 꼭 flush
    except Exception as e:
        print(json.dumps({"error": str(e)}), flush=True)
