package com.example.ai.demo.tool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PDFGenerationToolTest {

    @Test
    void generatePDF() {
        PDFGenerationTool pdfGenerationTool = new PDFGenerationTool();
        String content = "Hello World";
        String result = pdfGenerationTool.generatePDF("test.pdf", content);
        System.out.println(result);
        assertNotNull(result);
    }
}