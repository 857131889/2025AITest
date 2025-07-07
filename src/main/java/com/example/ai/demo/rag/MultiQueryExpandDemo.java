package com.example.ai.demo.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.rag.Query;
import org.springframework.ai.rag.preretrieval.query.expansion.MultiQueryExpander;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MultiQueryExpandDemo {

    private final ChatClient.Builder chatClientBuilder;

    public MultiQueryExpandDemo(ChatModel dashscopeChatModel) {
        this.chatClientBuilder = ChatClient.builder(dashscopeChatModel);
    }

    public List<Query> expand(String query) {
        MultiQueryExpander queryExpander = MultiQueryExpander.builder()
                .chatClientBuilder(chatClientBuilder)
                .includeOriginal(false) // 不包含原始查询
                .numberOfQueries(3) // 生成3个查询变体
                .build();
        List<Query> queries = queryExpander.expand(new Query(query));
        return queries;
    }
}
