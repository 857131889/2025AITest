package com.example.ai.demo.tool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.example.ai.constant.FileConstant;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class ResourceDownloadTool {
    @Tool(description = "Download resource from URL")
    public String downloadResouce(@ToolParam(description = "URL of the resource to download") String url,
                                  @ToolParam(description = "Name of the file to save the download resource") String fileName){
        String fileDir = FileConstant.FILE_SAVE_DIR + "/download/";
        String filePath = fileDir + fileName;
        try {
            FileUtil.mkdir(fileDir);
            HttpUtil.downloadFile(url, filePath);
            return "Download success to" + filePath;
        } catch (Exception e) {
            return "Download failed" + e.getMessage();
        }
    }
}
