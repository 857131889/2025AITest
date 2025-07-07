package com.example.ai.rag;

import com.example.ai.demo.rag.MultiQueryExpandDemo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.ai.rag.Query;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MultiQueryExpandDemoTest {
    @Resource
    private MultiQueryExpandDemo multiQueryExpandDemo;

    @Test
    void expand() {
        List<Query> queries = multiQueryExpandDemo.expand("你好");
        Assertions.assertNotNull(queries);
    }
}