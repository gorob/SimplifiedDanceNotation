package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.model.dance.ChoreographyMetaInfo;
import com.gorob.simplified.dance.notation.model.dance.Dance;
import com.gorob.simplified.dance.notation.model.dance.MediaRef;
import com.gorob.simplified.dance.notation.model.dance.MusicMetaInfo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AccessLevel;
import lombok.Getter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
            addTitleSection(dance);
            addChoreographySection(dance);
            addMusicSection(dance);
            getPdfDocument().close();
        } catch (DocumentException | IOException ex) {
            throw new RuntimeException("Error on creating pdf dance overview!", ex);
        }
    }


    private void addTitleSection(Dance dance){
        getPdfDocument().add(new Paragraph(dance.getTitle() + " (" + dance.getWall() + " Wall, " + dance.getCount() + " Count)", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD)));
    }

    private void addChoreographySection(Dance dance){
        ChoreographyMetaInfo choreographyMetaInfo = dance.getChoreographyMetaInfo();
        getPdfDocument().add(new Paragraph("Choreographie: " + choreographyMetaInfo.getCreatorName() + " (" + choreographyMetaInfo.getYear() + ")", FontFactory.getFont(FontFactory.HELVETICA, 14)));
        addMediaRefs(choreographyMetaInfo.getMediaReferences());
    }

    private void addMusicSection(Dance dance){
        MusicMetaInfo musicMetaInfo = dance.getMusicMetaInfo();
        getPdfDocument().add(new Paragraph("Musik: " + musicMetaInfo.getTitle() + " von " + musicMetaInfo.getCreatorName() + " (" + musicMetaInfo.getYear() + ")", FontFactory.getFont(FontFactory.HELVETICA, 14)));
        addMediaRefs(musicMetaInfo.getMediaReferences());
    }

    private void addMediaRefs(List<MediaRef> mediaRefs){
        mediaRefs.forEach(mediaRef -> {
            getPdfDocument().add(new Paragraph("   => " + mediaRef.getService().getName() + ": " + mediaRef.getRef(), FontFactory.getFont(FontFactory.HELVETICA, 10)));
        });
    }
}
