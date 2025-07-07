package com.example.ai.demo.tool;

import com.example.ai.demo.tool.WebScrapingTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebScrapingToolTest {

    @Test
    void scrapeWebPage() {
        WebScrapingTool webScrapingTool = new WebScrapingTool();
        String url = "https://baike.baidu.com/item/%E9%87%91%E6%AD%A3%E6%81%A9/26";
        String result = webScrapingTool.scrapeWebPage(url);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}