package com.example.ai.config;

import com.example.ai.rag.HappyAppDocumentLoader;
import com.example.ai.rag.MyKeywordEnricher;
import com.example.ai.rag.MyTokenTextSpliter;
import jakarta.annotation.Resource;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class HappyAppVectorStoreConfig {

    @Resource
    HappyAppDocumentLoader happyAppDocumentLoader;

    @Resource
    MyTokenTextSpliter myTokenTextSplitter;

    @Resource
    MyKeywordEnricher myKeywordEnricher;

    @Primary
    @Bean
    VectorStore happyAppVectors(@Qualifier("dashscopeEmbeddingModel") EmbeddingModel embeddingModel) {
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(embeddingModel)
                .build();

        List<Document> documents = happyAppDocumentLoader.loadMarkdownDocument();

        List<Document> splitedDocuments = myTokenTextSplitter.splitCustomized(documents);

        List<Document> enrichedDocuments = myKeywordEnricher.enrichDocuments(splitedDocuments);

        simpleVectorStore.add(enrichedDocuments);
        return simpleVectorStore;
    }
}
