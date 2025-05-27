import os
import sys
import json
import warnings

# 모든 경고 메시지 제거
warnings.filterwarnings("ignore")

# transformers 로그 완전 비활성화
os.environ["TRANSFORMERS_NO_ADVISORY_WARNINGS"] = "1"
os.environ["TRANSFORMERS_VERBOSITY"] = "error"

import torch
from transformers import T5Tokenizer, T5ForConditionalGeneration

# 모델 로드
try:
    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    model_path = "/home/t25121/et5-base"

    tokenizer = T5Tokenizer.from_pretrained(model_path, legacy=True)
    model = T5ForConditionalGeneration.from_pretrained(model_path).to(device)

except Exception:
    print(json.dumps({
        "transformed": "변환 실패",
        "error": "모델 로드 실패"
    }, ensure_ascii=False), flush=True)
    sys.exit(1)

# 표준 입력 대기 루프
while True:
    try:
        line = sys.stdin.readline()
        if not line:
            break

        input_json = json.loads(line)
        prompt = input_json.get("content")
        if not prompt:
            raise ValueError("입력값 없음")

        prompt = prompt.strip()
        input_text = f"다음을 일기처럼 바꾸세요: {prompt}"
        inputs = tokenizer(input_text, return_tensors="pt").to(device)

        output_ids = model.generate(
            inputs["input_ids"],
            attention_mask=inputs["attention_mask"],
            pad_token_id=tokenizer.eos_token_id,
            max_length=512,
            num_beams=1,
            early_stopping=True,
            do_sample=False
        )

        output = tokenizer.decode(output_ids[0], skip_special_tokens=True)
        print(json.dumps({
            "transformed": output
        }, ensure_ascii=False), flush=True)

    except Exception:
        print(json.dumps({
            "transformed": "변환 실패",
            "error": "예외 발생"
        }, ensure_ascii=False), flush=True)
