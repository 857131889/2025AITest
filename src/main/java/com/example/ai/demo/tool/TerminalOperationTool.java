package com.example.ai.demo.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TerminalOperationTool {
    @Tool(description = "Executes a terminal command")
    public String executeTerminalCommand(@ToolParam (description = "Command to execute in the terminal")String command){
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = builder.start();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK" ))){
                String line ="";
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK" ))){
                String line ="";
                while ((line = reader.readLine()) != null) {
                    output.append("command esecution failed with exit code").append(line).append("\n");
                }
            }
        }catch (Exception e){
            output.append("error").append(e.getMessage());
        }
        return output.toString();
    }
}
