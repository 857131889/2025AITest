package com.example.ai.demo.rag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;

@Slf4j
public class HappyAppContextQueryAugumenterFactory {

    public static ContextualQueryAugmenter createInstance(){
        PromptTemplate promptTemplate = new PromptTemplate("""
                你应该输出下面的内容：
                抱歉，我只是一本裁定书
        """);
        return ContextualQueryAugmenter.builder()
                .allowEmptyContext(false)
                .emptyContextPromptTemplate(promptTemplate)
                .build();
    }
}
