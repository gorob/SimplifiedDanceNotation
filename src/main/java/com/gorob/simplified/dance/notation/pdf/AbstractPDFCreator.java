package com.gorob.simplified.dance.notation.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AccessLevel;
import lombok.Getter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Getter(AccessLevel.PROTECTED)
public abstract class AbstractPDFCreator<MODEL extends Object> {
    private Document pdfDocument;

    private String defaultFontName;
    private int defaultFontSize;

    public AbstractPDFCreator(String defaultFontName, int defaultFontSize){
        this.pdfDocument = new Document();
        this.defaultFontName = defaultFontName;
        this.defaultFontSize = defaultFontSize;
    }

    public void generate(MODEL model, File outputFile){
        try {
            PdfWriter.getInstance(getPdfDocument(), new FileOutputStream(outputFile));
            getPdfDocument().open();
            createAndAddContent(model);
            getPdfDocument().close();
        } catch (DocumentException | IOException ex) {
            throw new RuntimeException("Error on creating pdf dance overview!", ex);
        }
    }

    protected abstract void createAndAddContent(MODEL model);

    protected void addMainTitle(String mainTitle){
        addTextParagraph(mainTitle, FontFactory.HELVETICA, 20, Font.BOLD);
        addNewLine(20);
    }

    protected void addSubTitle(String subTitle){
        addTextParagraph(subTitle, FontFactory.HELVETICA, 12, Font.BOLD, Color.BLUE);
        addNewLine(5);
    }

    protected void addTextParagraph(String text){
        addTextParagraph(text, getDefaultFontSize());
    }

    protected void addTextParagraph(String text, int fontSize){
        addTextParagraph(text, getDefaultFontName(), fontSize, Font.NORMAL);
    }

    protected void addTextParagraph(String text, String fontName, int fontSize, int style){
        addTextParagraph(text, fontName, fontSize, style, Color.BLACK);
    }

    protected void addTextParagraph(String text, String fontName, int fontSize, int style, Color color){
        getPdfDocument().add(createParagraph(text, fontName, fontSize, style, color));
    }

    protected void addNewLine() {
        addNewLine(getDefaultFontSize());
    }

    protected void addNewLine(int fontSize){
        addTextParagraph(System.lineSeparator(), fontSize);
    }

    protected void addTable(PdfPTable table){
        getPdfDocument().add(table);
    }

    protected void addTableCells(PdfPTable table, String... texts){
        addTableCells(table, Font.NORMAL, texts);
    }

    protected void addTableCells(PdfPTable table, int style, String... texts){
        addTableCells(table, getDefaultFontSize(), style, texts);
    }

    protected void addTableCells(PdfPTable table, int fontSize, int style, String... texts){
        addTableCells(table, getDefaultFontName(), fontSize, style, texts);
    }

    private void addTableCells(PdfPTable table, String fontName, int fontSize, int style, String... texts){
        Arrays.stream(texts).forEach(text -> table.addCell(createTableCell(text, fontName, fontSize, style)));
    }

    protected PdfPTable createTable(int numColumns, float... widths){
        PdfPTable table = new PdfPTable(numColumns);
        table.setWidthPercentage(100);
        table.setWidths(widths);
        return table;
    }

    private PdfPCell createTableCell(String text, String fontName, int fontSize, int style){
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(text, getFont(fontName, fontSize, style, Color.BLACK)));
        cell.setBorder(0);
        return cell;
    }

    private Paragraph createParagraph(String text, String fontName, int fontSize, int style, Color color){
        return new Paragraph(text, getFont(fontName, fontSize, style, color));
    }

    private Font getFont(String fontName, int fontSize, int style, Color color){
        return FontFactory.getFont(fontName, fontSize, style, color);
    }
}
