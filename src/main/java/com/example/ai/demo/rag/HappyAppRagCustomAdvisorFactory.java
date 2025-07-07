package com.example.ai.demo.rag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.filter.Filter;
import org.springframework.ai.vectorstore.filter.FilterExpressionBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HappyAppRagCustomAdvisorFactory {

    public static Advisor createAppCustomerAdvisor(VectorStore vectorStore, String status) {
        Filter.Expression expression = new FilterExpressionBuilder()
                .eq("status", status)
                .build();

        VectorStoreDocumentRetriever documentRetriever = VectorStoreDocumentRetriever.builder()
                .vectorStore(vectorStore)
                .filterExpression(expression)
                .similarityThreshold(0.5)
                .topK(3)
                .build();

        return RetrievalAugmentationAdvisor.builder().documentRetriever(documentRetriever)
                .documentRetriever(documentRetriever)
//                .queryAugmenter(ContextualQueryAugmenter.builder().allowEmptyContext(false).build())
                .queryAugmenter(HappyAppContextQueryAugumenterFactory.createInstance())
                .build();
    }
}
