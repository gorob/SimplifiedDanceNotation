package com.gorob.simplified.dance.notation.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Getter(AccessLevel.PROTECTED)
public abstract class AbstractPDFCreator<MODEL extends Object> {
    private Document pdfDocument;

    public AbstractPDFCreator(){
        this.pdfDocument = new Document();
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

    protected void addTextParagraph(String text){
        addTextParagraph(text, FontFactory.HELVETICA, 10, Font.NORMAL);
    }

    protected void addTextParagraph(String text, String fontName, int fontSize, int style){
        getPdfDocument().add(new Paragraph(text, createFont(fontName, fontSize, style)));
    }

    protected Font createFont(String fontName, int fontSize, int style){
        return FontFactory.getFont(fontName, fontSize, style);
    }
}
