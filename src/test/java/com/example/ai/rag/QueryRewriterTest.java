package com.example.ai.rag;

import com.example.ai.demo.rag.QueryRewriter;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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