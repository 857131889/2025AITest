package com.example.ai.demo.invoke;

import dev.langchain4j.community.model.dashscope.QwenChatModel;

public class LangChainAiInvoke {
    public static void main(String[] args) {
        QwenChatModel qwenChatModel = QwenChatModel.builder()
                .apiKey(ApiKey.API_KEY)
                .modelName("qwen-max")
                .build();
        String response = qwenChatModel.chat("你是谁");
        System.out.println(response);
    }
}
