package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.model.dance.MediaRef;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import lombok.AccessLevel;
import lombok.Getter;

import java.awt.*;
import java.util.List;

@Getter(AccessLevel.PRIVATE)
public class DanceOverviewGenerator extends AbstractPDFCreator<DanceOverview> {
    public DanceOverviewGenerator(){
        this(FontFactory.HELVETICA, 10);
    }

    public DanceOverviewGenerator(String defaultFontName, int defaultFontSize){
        super(defaultFontName, defaultFontSize);
    }

    @Override
    protected void createAndAddContent(DanceOverview model) {
        addTitleSection(model);

        addChoreographySection(model);
        addNewLine();

        addMusicSection(model);
        addNewLine();

        addInstructionSection(model);
    }

    private void addTitleSection(DanceOverview danceOverview){
        addMainTitle(danceOverview.getTitle());
    }

    private void addChoreographySection(DanceOverview danceOverview){
        addMediaSection(danceOverview.getChoreographyTitle(), danceOverview.getChoreographyMediaRefs());
    }

    private void addMusicSection(DanceOverview danceOverview){
        addMediaSection(danceOverview.getMusicTitle(), danceOverview.getMusicMediaRefs());
    }

    private void addMediaSection(String mediaSectionTitle, List<MediaRef> mediaRefs){
        addSubTitle(mediaSectionTitle);
        addMediaReferenceTable(mediaRefs);
    }

    private void addMediaReferenceTable(List<MediaRef> mediaRefs){
        PdfPTable table = createTable(2, 18, 82);
        mediaRefs.forEach(mediaRef -> {
            addTableCells(table, Font.BOLD, mediaRef.getService().getName());
            addTableCells(table, mediaRef.getRef());
        });
        addTable(table);
    }

    private void addInstructionSection(DanceOverview danceOverview) {
        addSubTitle(danceOverview.getDanceInstructionsTitle());

        PdfPTable table = createTable(2, 1, 10);

        addTableCells(table, Font.BOLD, "Count", "Instruction");

        DanceMoveInstructionText danceMoveInstructionText = danceOverview.getDanceMoveInstructionTexts().get(0);
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(0).getBodyMovementInstructionTexts().get(0));
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(0).getBodyMovementInstructionTexts().get(1));
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(1).getBodyMovementInstructionTexts().get(0));
        addBodyMovementInstruction(table, danceMoveInstructionText.getBodyMovementGroupInstructionTexts().get(1).getBodyMovementInstructionTexts().get(1));

        addTable(table);
    }

    private void addBodyMovementInstruction(PdfPTable table, BodyMovementInstructionText bodyMovementInstructionText){
        addTableCells(table, "1", bodyMovementInstructionText.getText());
    }

}
