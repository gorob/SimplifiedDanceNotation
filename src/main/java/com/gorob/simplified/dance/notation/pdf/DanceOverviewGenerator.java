package com.gorob.simplified.dance.notation.pdf;

import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;

@Getter(AccessLevel.PRIVATE)
public class DanceOverviewGenerator extends AbstractPDFCreator<DanceOverview> {
    @Override
    protected void createAndAddContent(DanceOverview model) {
        addTitleSection(model);
        addChoreographySection(model);
        addMusicSection(model);

        addInstructionSection(model);
    }

    private void addTitleSection(DanceOverview danceOverview){
        addTextParagraph(danceOverview.getTitle(), FontFactory.HELVETICA, 20, Font.BOLD);
    }

    private void addChoreographySection(DanceOverview danceOverview){
        addTextParagraph(danceOverview.getChoreographyTitle(), FontFactory.HELVETICA, 14, Font.NORMAL);
        addMediaRefs(danceOverview.getChoreographyMediaRefs());
    }

    private void addMusicSection(DanceOverview danceOverview){
        addTextParagraph(danceOverview.getMusicTitle(), FontFactory.HELVETICA, 14, Font.NORMAL);
        addMediaRefs(danceOverview.getMusicMediaRefs());
    }

    private void addMediaRefs(List<String> mediaRefs){
        mediaRefs.forEach(mediaRef -> {
            addTextParagraph(mediaRef, FontFactory.HELVETICA, 10, Font.NORMAL);
        });
    }

    private void addInstructionSection(DanceOverview model) {
        DanceMoveInstructionText danceMoveInstructionText = model.getDanceMoveInstructionTexts().get(0);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        // setting column widths
        table.setWidths(new float[] {1, 10});

        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase("Count", createFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
        table.addCell(cell);

        cell = new PdfPCell();
        cell.setPhrase(new Phrase("Instruction", createFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
        table.addCell(cell);

        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(0).getBodyMovementInstructionTexts().get(0));
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(0).getBodyMovementInstructionTexts().get(1));
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(1).getBodyMovementInstructionTexts().get(0));
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(1).getBodyMovementInstructionTexts().get(1));

        getPdfDocument().add(table);


    }


    private void addBodyMovementInstruction(PdfPTable table, BodyMovementInstructionText bodyMovementInstructionText){
        String countStr = "1";

        StringBuffer instructionText = new StringBuffer();
        bodyMovementInstructionText.getBodyPartMovementInstructionTexts().forEach(bodyPartMovementInstructionText -> instructionText.append(bodyPartMovementInstructionText.getInstructionText()).append("; "));

        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(countStr, createFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
        table.addCell(cell);

        cell = new PdfPCell();
        cell.setPhrase(new Phrase(instructionText.toString(), createFont(FontFactory.HELVETICA, 10, Font.NORMAL)));
        table.addCell(cell);
    }

}
