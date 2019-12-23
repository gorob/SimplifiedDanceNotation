package com.gorob.simplified.dance.notation.pdf;

import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.PdfPTable;
import lombok.AccessLevel;
import lombok.Getter;

import java.awt.*;
import java.util.List;

@Getter(AccessLevel.PRIVATE)
public class DanceOverviewGenerator extends AbstractPDFCreator<DanceOverview> {
    @Override
    protected void createAndAddContent(DanceOverview model) {
        addTitleSection(model);
        addChoreographySection(model);
        addMusicSection(model);
    }

    private void addTitleSection(DanceOverview danceOverview){
        addTextParagraph(danceOverview.getTitle(), FontFactory.HELVETICA, 20, Font.BOLD);
    }

    private void addChoreographySection(DanceOverview danceOverview){
        addTextParagraph(danceOverview.getChoreographyTitle(), FontFactory.HELVETICA, 14, Font.PLAIN);
        addMediaRefs(danceOverview.getChoreographyMediaRefs());
    }

    private void addMusicSection(DanceOverview danceOverview){
        addTextParagraph(danceOverview.getMusicTitle(), FontFactory.HELVETICA, 14, Font.PLAIN);
        addMediaRefs(danceOverview.getMusicMediaRefs());
    }

    private void addMediaRefs(List<String> mediaRefs){
        mediaRefs.forEach(mediaRef -> {
            addTextParagraph(mediaRef, FontFactory.HELVETICA, 10, Font.PLAIN);
        });
    }

//    private void addInstructionTable(){
//        PdfPTable table = new PdfPTable(4);
//        table.setWidthPercentage(100);
//        // setting column widths
//        table.setWidths(new float[] {6.0f, 6.0f, 6.0f, 6.0f});
//        PdfPCell cell = new PdfPCell();
//        // table headers
//        cell.setPhrase(new Phrase("First Name", font));
//        table.addCell(cell);
//    }

}
