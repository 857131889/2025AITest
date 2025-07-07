package com.example.ai.demo.tool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceDownloadToolTest {

    @Test
    void downloadResouce() {
        ResourceDownloadTool resourceDownloadTool = new ResourceDownloadTool();
        String url = "https://ugc-img.ifengimg.com/img/2022/7/7/8HQcnkDiBoz/7db58792-d5ee-4867-8e7d-fda5bc80f289_w640_h429.jpeg";
        String fileName = "Mikado.jpeg";
        String result = resourceDownloadTool.downloadResouce(url, fileName);
        assertNotNull(result);
    }
}