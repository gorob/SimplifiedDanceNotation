package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.parser.movedefinitions.DanceMoveDefinitionsParser;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DanceOverviewGeneratorTest extends AbstractTest {
    @Test
    public void testGenerate() throws IOException {
        File pdfErgFile = new File(getTempRoot(), "dance.pdf");

        DanceMoveDefinitionsParser parser = new DanceMoveDefinitionsParser();

        new DanceOverviewGenerator().generate(getTmc().createDefaultDanceOverview(), pdfErgFile);

        File tmpFile = new File("/tmp", pdfErgFile.getName());
        FileUtils.copyFile(pdfErgFile, tmpFile);
        Desktop.getDesktop().open(tmpFile);
    }


}