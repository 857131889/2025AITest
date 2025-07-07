package com.example.ai.demo.tool;

import org.springframework.ai.tool.annotation.Tool;

public class WeatherTools {

    @Tool(description = "Get the cunrrent weather conditions of a sepcified city")
    public String getWeather(String city) {
        return "厦门今天的天气高温预警请注意防晒";
    }
}
