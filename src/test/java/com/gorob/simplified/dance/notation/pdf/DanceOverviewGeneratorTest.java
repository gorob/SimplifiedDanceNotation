package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.IDanceMoveDefinition;
import com.gorob.simplified.dance.notation.model.dance.*;
import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveDefinitions;
import com.gorob.simplified.dance.notation.parser.movedefinitions.DanceMoveDefinitionsParser;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DanceOverviewGeneratorTest extends AbstractTest {
    @Test
    public void testGenerate() throws IOException {
        File pdfErgFile = new File(getTempRoot(), "dance.pdf");

        File dmdFilesFolder = copyFolderToTemp("/definitions", "dmdfiles");
        DanceMoveDefinitions danceMoveDefinitions = new DanceMoveDefinitions(dmdFilesFolder);

        Dance dance = new Dance(2, 32, 32, "4/4");
        dance.addChoreographyMetaInfo(new ChoreographyMetaInfo("Shout Shout", "Yvonne Zielonka",
                2013, new MediaRef(MediaService.YOUTUBE, MediaType.VIDEO, "https://www.youtube.com/watch?v=rouN3dS0A60")));
        dance.addMusicMetaInfo(new MusicMetaInfo("Shout Shout (Knock Yourself Out)", "Rocky Sharpe & The Replays",
                2013, new MediaRef(MediaService.AMAZON_MUSIC, MediaType.MUSIC,
                "https://music.amazon.de/albums/B00AVH7D0M?trackAsin=B00AVH7H2Q&amp;ref=dm_sh_Ez04ftdT9VtzX7rxs97sOMqlH")));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("HeelHeelRightWithHands"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("BehindSideCrossLeftDirection"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("HeelHeelLeftWithHands"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("BehindSideCrossRightDirection"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("CharlestonStepArcStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("ShuffleForwardStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("MamboForwardStartWithLF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("RunBackThreeStepsStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("CoasterStepStartWithLF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("StepTurnQuarterLeftStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("StepTurnQuarterLeftStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("JazzBoxStartWithRF"));
        dance.addDanceMove(danceMoveDefinitions.getDanceMoveVariantDefinitionById("HeelToeHeelSwivelsRightAndLeft"));

        DanceMoveDefinitionsParser parser = new DanceMoveDefinitionsParser();

        new DanceOverviewGenerator().generate(dance, pdfErgFile);

        System.out.println(pdfErgFile.getAbsolutePath());
    }
}