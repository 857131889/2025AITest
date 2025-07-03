package com.example.ai.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.rag.Query;
import org.springframework.ai.rag.preretrieval.query.transformation.QueryTransformer;
import org.springframework.ai.rag.preretrieval.query.transformation.RewriteQueryTransformer;
import org.springframework.stereotype.Component;

@Component
public class QueryRewriter {
    private final QueryTransformer queryTransformer;

    public QueryRewriter(ChatModel dashscopeModel) {
        ChatClient.Builder builder = ChatClient.builder(dashscopeModel);
        queryTransformer = RewriteQueryTransformer.builder().chatClientBuilder(builder).build();
    }

    public String doQueryRewrite(String query) {
        return queryTransformer.transform(new Query(query)).text();
    }
}
