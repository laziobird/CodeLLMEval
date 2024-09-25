from transformers import AutoTokenizer, AutoModel
import transformers
import torch
modelname = r"/mnt/workspace/CodeLlama-7b-hf"
tokenizer = AutoTokenizer.from_pretrained(modelname)
 
t1 = time.time()
pipeline = transformers.pipeline(
    "text-generation",
    model=modelname,
    torch_dtype=torch.float16,
    device_map="auto",
)
sequences = pipeline(
    '用java实现堆排序',
    do_sample=True,
    top_k=10,
    temperature=0.1,
    top_p=0.95,
    num_return_sequences=1,
    eos_token_id=tokenizer.eos_token_id,
    max_length=500,
)
for seq in sequences:
    print(f"Result: {seq['generated_text']}")
t2 = time.time()
