package com.example.ai.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HappyAppTest {

    @Resource
    private HappyApp happyApp;

    @Test
    void testChat(){
        String chatId = UUID.randomUUID().toString();

        //第一轮对话
        String message = "你好,我是人类";
        String response = happyApp.chat(message,chatId);
        Assertions.assertNotNull(response);

        //第二轮对话
        message = "我是谁";
        response = happyApp.chat(message,chatId);
        Assertions.assertNotNull(response);
    }

    @Test
    void testChatReport(){
        String chatId = UUID.randomUUID().toString();
        String message = "你好,我是人类";
        HappyApp.ActorsFilms actorsFilms = happyApp.chatReport(message,chatId);
        System.out.println(actorsFilms);
        Assertions.assertNotNull(actorsFilms);
    }
}