package com.example.ai.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OllamaAiInvoke implements CommandLineRunner {
    @Resource(name = "ollamaChatModel")
    private ChatModel ollamaChatModel;
    @Override
    public void run(String... args) throws Exception {
        AssistantMessage asistantMessage = ollamaChatModel.call(new Prompt("我是ollama")).getResult().getOutput();
        System.out.println(asistantMessage.getText());
    }
}
