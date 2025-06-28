package com.example.ai.advisor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.advisor.api.*;
import reactor.core.publisher.Flux;

@Slf4j
public class MyLoggerAdvisor implements CallAroundAdvisor, StreamAroundAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(MyLoggerAdvisor.class);

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 请求调用前
     * @param advisedRequest
     * @return
     */
    private AdvisedRequest before(AdvisedRequest advisedRequest) {
        // 打印请求文本
        logger.info("AI Request: {}", advisedRequest.userText());
        return advisedRequest;
    }

    /**
     * 请求调用后
     * @param advisedResponse
     */
    private void observeAfter(AdvisedResponse advisedResponse) {
        // 打印返回结果
        if (advisedResponse.response() != null) {
            logger.info("AI Response: {}", advisedResponse.response().getResult().getOutput().getText());
        }
    }

    @Override
    public AdvisedResponse aroundCall(AdvisedRequest advisedRequest, CallAroundAdvisorChain chain) {
        // 请求前处理
        advisedRequest = before(advisedRequest);
        // 调用链执行
        AdvisedResponse advisedResponse = chain.nextAroundCall(advisedRequest);
        // 请求后观察
        observeAfter(advisedResponse);
        return advisedResponse;
    }

    @Override
    public Flux<AdvisedResponse> aroundStream(AdvisedRequest advisedRequest, StreamAroundAdvisorChain chain) {
        return null;
    }
}
