package com.example.ai.demo.tool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileOperationToolTest {

    @Test
    void writeFile() {
        FileOperationTool tool = new FileOperationTool();
        String fileName = "hello.txt";
        String content = "今天厦门高温注意防晒";
        String result = tool.writeFile(fileName, content);
        Assertions.assertNotNull(result);
    }

    @Test
    void readFile() {
        FileOperationTool tool = new FileOperationTool();
        String fileName = "hello.txt";
        String result = tool.readFile(fileName);
        Assertions.assertNotNull(result);
    }
}