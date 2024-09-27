

# CodeLLMEval
Evaluation based on programming scenarios

## \[ English | [中文](README_zh.md) \]
👋 Join our [WeChat](assets/wechat.jpg) 

##Scoring mode
###[High frequency defects - continuously updating] (high-frequency bugs/sample. json)
|Defect scenario | Serious result | Test set case|
| ----------------------------------------------------------------- | -------------------------------- | --------- |
|Dead Loop | Severe cause CPU 100%, service crash | 2 |
|Memory leak, memory overflow | Severe OOM, service crashes | 2 |
|Thread Deadlock | Concurrent threads compete for resource deadlocks, severely causing CPU 100% or OOM, service unavailability or failure | 2 |
|Inconsistent concurrent data | Improper operation in multi-threaded situations leads to inconsistent and dirty data | 1 |
* Dead loop search
Compare and evaluate the effectiveness
![loop](assets/loop.jpg)
* Lookuping for multi threaded deadlock 
* Memory leakage
