package com.example.ai.demo.invoke;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;

public class SpringInvoke implements CommandLineRunner {
    @Resource(name = "dashscopeChatModel")
    private ChatModel dashscopeChatModel;

    @Override
    public void run(String... args) throws Exception {
        AssistantMessage output = dashscopeChatModel.call(new Prompt("我是dashscope")).getResult().getOutput();
        System.out.println(output.getText());
    }
}
