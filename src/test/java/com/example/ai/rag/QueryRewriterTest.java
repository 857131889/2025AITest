package com.example.ai.rag;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QueryRewriterTest {

    @Resource
    QueryRewriter queryRewriter;

    @Test
    void doQueryRewrite() {
        String doQueryRewrite = queryRewriter.doQueryRewrite("你好");
        System.out.println(doQueryRewrite);
        Assertions.assertNotNull(doQueryRewrite);
    }
}