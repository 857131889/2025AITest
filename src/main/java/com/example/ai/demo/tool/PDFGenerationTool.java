package com.example.ai.demo.tool;

import cn.hutool.core.io.FileUtil;
import com.example.ai.constant.FileConstant;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class PDFGenerationTool {
    @Tool(description = "Generate PDF file with given content")
    public String generatePDF(@ToolParam(description = "Name of the file to save the generated PDF") String fileName,
                              @ToolParam(description = "Content of the PDF") String content) {
        String fileDir = FileConstant.FILE_SAVE_DIR + "/pdf";
        String filePath = fileDir + "/" + fileName;
        try {
            FileUtil.mkdir(fileDir);

            try (PdfWriter writer = new PdfWriter(filePath);
                 PdfDocument pdf = new PdfDocument(writer);
                 Document document = new Document(pdf)) {

                PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H");
                document.setFont(font);

                Paragraph paragraph = new Paragraph(content);

                document.add(paragraph);
            }
            return "PDF file generated successfully";
        } catch (Exception e) {
            return "Error occurred while generating PDF file" + e.getMessage();
        }

    }
}
