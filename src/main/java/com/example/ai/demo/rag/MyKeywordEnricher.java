package com.example.ai.demo.rag;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.KeywordMetadataEnricher;
import org.springframework.ai.transformer.SummaryMetadataEnricher;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MyKeywordEnricher {
    @Resource
    private ChatModel dashscopeChatModel;

    public List<Document> enrichDocuments(List<Document> documents) {
        KeywordMetadataEnricher keywordMetadataEnricher = new KeywordMetadataEnricher(dashscopeChatModel, 5);
        return keywordMetadataEnricher.apply(documents);
    }

    public List<Document> enrichDocumentsBySummary(List<Document> documents) {
        SummaryMetadataEnricher summaryKeywordMetadataEnricher = new SummaryMetadataEnricher(dashscopeChatModel,
                List.of(SummaryMetadataEnricher.SummaryType.PREVIOUS, SummaryMetadataEnricher.SummaryType.CURRENT, SummaryMetadataEnricher.SummaryType.NEXT));
        return summaryKeywordMetadataEnricher.apply(documents);

    }
}