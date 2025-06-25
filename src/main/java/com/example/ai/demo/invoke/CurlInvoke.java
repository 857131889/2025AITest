package com.example.ai.demo.invoke;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.ai.demo.invoke.ApiKey;

public class CurlInvoke {
    public static void main(String[] args) {
        String apiKey = ApiKey.API_KEY;
        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("请先在环境变量中设置 DASHSCOPE_API_KEY");
            return;
        }

        String url = "https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions";

        JSONObject body = new JSONObject();
        body.set("model", "qwen-plus");
        JSONArray messages = new JSONArray();
        messages.add(
                new JSONObject().set("role", "system").set("content", "You are a helpful assistant.")
        );
        messages.add(
                new JSONObject().set("role", "user").set("content", "你是谁？")
        );
        body.set("messages", messages);

        HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(body.toString())
                .timeout(15000)
                .execute();

        if (response.isOk()) {
            System.out.println(response.body());
        } else {
            System.err.printf("请求失败，状态码：%d，响应：%s%n", response.getStatus(), response.body());
        }
    }
}
