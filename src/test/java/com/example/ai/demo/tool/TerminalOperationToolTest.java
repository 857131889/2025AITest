package com.example.ai.demo.tool;

import com.example.ai.demo.tool.TerminalOperationTool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalOperationToolTest {

    @Test
    void executeTerminalCommand() {
        TerminalOperationTool terminalOperationTool = new TerminalOperationTool();
        String command = "dir";
        String result = terminalOperationTool.executeTerminalCommand(command);
        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}