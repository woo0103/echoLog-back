import json
import sys
import torch
from transformers import T5TokenizerFast, T5ForConditionalGeneration

try:
    device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
    model_path = "/home/t25121/et5-train"

    model = T5ForConditionalGeneration.from_pretrained(model_path).to(device)
    tokenizer = T5TokenizerFast.from_pretrained(model_path)

except Exception:
    sys.exit(1)  # 모델 로딩 실패 시 조용히 종료

while True:
    try:
        line = sys.stdin.readline()
        if not line:
            break

        input_json = json.loads(line)
        prompt = input_json.get("content", "").strip()

        input_text = f"{prompt}"
        inputs = tokenizer(input_text, return_tensors="pt").to(device)

        output_ids = model.generate(
            inputs["input_ids"],
            attention_mask=inputs["attention_mask"],
            max_length=4096,
            num_beams=5,
            early_stopping=True,
            no_repeat_ngram_size=6,
            do_sample=True,
            temperature=0.5,
            num_return_sequences=1
        )
        output = tokenizer.decode(output_ids[0], skip_special_tokens=True).replace('<extra_id_0>', '')

        print(json.dumps({"transformed": output}, ensure_ascii=False), flush=True)

    except Exception:
        print(json.dumps({
            "transformed": "변환 실패",
            "error": "예외 발생"
        }, ensure_ascii=False), flush=True)
