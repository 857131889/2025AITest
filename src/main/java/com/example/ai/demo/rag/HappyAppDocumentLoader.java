package com.example.ai.demo.rag;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.markdown.MarkdownDocumentReader;
import org.springframework.ai.reader.markdown.config.MarkdownDocumentReaderConfig;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class HappyAppDocumentLoader {

    private final ResourcePatternResolver resourcePatternResolver;

    HappyAppDocumentLoader(ResourcePatternResolver resourcePatternResolver) {
        this.resourcePatternResolver = resourcePatternResolver;
    }

    public List<Document> loadMarkdownDocument() {
        List<Document> allDocuments = new ArrayList<>();
        try {
            Resource[] resources = resourcePatternResolver.getResources("classpath:markdown/*.md");
            for (Resource resource : resources) {
                String fileName = resource.getFilename();
                String status = fileName.substring(fileName.indexOf("-") + 1, fileName.lastIndexOf(".md"));
                log.info("Loading markdow document: {}", resource.getFilename());
                MarkdownDocumentReaderConfig config = MarkdownDocumentReaderConfig.builder()
                        .withHorizontalRuleCreateDocument(true)
                        .withIncludeCodeBlock(false)
                        .withIncludeBlockquote(false)
                        .withAdditionalMetadata("filename", fileName)
                        .withAdditionalMetadata("status", status)
                        .build();
                MarkdownDocumentReader reader = new MarkdownDocumentReader(resource, config);
                allDocuments.addAll(reader.get());
            }
        } catch (Exception e) {
            log.error("Error loading markdown documents", e);
        }
        return allDocuments;
    }
}
