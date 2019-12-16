package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.model.dance.Dance;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Getter(AccessLevel.PRIVATE)
public class DanceOverviewGenerator {

    private Document pdfDocument;

    public DanceOverviewGenerator(){
        this.pdfDocument = new Document();
    }

    public void generate(Dance dance, File outputFile){
        try {
            PdfWriter.getInstance(getPdfDocument(), new FileOutputStream(outputFile));
            getPdfDocument().open();
            getPdfDocument().add(new Paragraph("Hello World"));
            getPdfDocument().close();
        } catch (DocumentException | IOException ex) {
            throw new RuntimeException("Error on creating pdf dance overview!", ex);
        }
    }



}
