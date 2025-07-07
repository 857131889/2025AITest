package com.example.ai.demo.tool;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WebSearchTool {
    private static final String SEARCH_API_URL = "https://www.searchapi.io/api/v1/search";

    public final String apiKey;

    public WebSearchTool(String apiKey) {
        this.apiKey = apiKey;
    }

    public String searchweb(String query) {
        Map<String,Object> params = Map.of("q", query, "api_key", apiKey ,"engine","baidu");
        try {
            String result = HttpUtil.get(SEARCH_API_URL, params);
            JSONObject jsonObject = JSONUtil.parseObj(result);
            JSONArray organicResults = jsonObject.getJSONArray("organic_results");
            List<Object> objects = organicResults.subList(0,5);
            objects.stream().map(obj->{
                JSONObject tmpJSONObject = (JSONObject) obj;
                return tmpJSONObject.toString();
            }).collect(Collectors.joining(","));
            return result;

        }catch (Exception e){
            return "ERROR" + e.getMessage();
        }

    }
}
