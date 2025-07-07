package com.example.ai.demo.tool;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class WebScrapingTool {
    @Tool(description = "Scrape a web ")
    public String scrapeWebPage(@ToolParam(description = "URL of the web page to scrape") String url){
        try {
            Document doc = Jsoup.connect(url).get();
            return doc.title();
        }catch (Exception e){
            return "Error" + e.getMessage();
        }
    }
}
