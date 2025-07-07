package com.example.ai.demo.tool;

import com.example.ai.demo.tool.WebSearchTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebSearchToolTest {

    @Value("${search.api.api-key}")
    private String apiKey;

    @Test
    void searchWeb() {
        WebSearchTool webSearchTool = new WebSearchTool(apiKey);
        String query = "大而美法案";
        String result = webSearchTool.searchweb(query);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}