import whisper
import json
import sys
import traceback

try:
    model = whisper.load_model("large-v3-turbo")
except Exception as e:
    error_output = {
        "content": "STT 실패",
        "error": traceback.format_exc()
    }
    print(json.dumps(error_output, ensure_ascii=False), flush=True)
    sys.exit(1)

while True:
    try:
        line = sys.stdin.readline()
        if not line:
            continue

        input_path = line.strip()
        result = model.transcribe(input_path)

        output = {
            "content": result.get("text", "")
        }
        print(json.dumps(output, ensure_ascii=False), flush=True)

    except Exception:
        error_output = {
            "content": "STT 실패",
            "error": traceback.format_exc()
        }
        print(json.dumps(error_output, ensure_ascii=False), flush=True)
