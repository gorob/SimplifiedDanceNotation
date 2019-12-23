package com.gorob.simplified.dance.notation.parser.movedefinitions;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveDefinition;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class DanceMoveDefinitionsParserTest extends AbstractTest {
    @Test
    public void testParseDefinitionFiles() throws IOException {
        File dmdFilesFolder = copyFolderToTemp("/definitions", "dmdfiles");
        assertTrue(dmdFilesFolder.listFiles().length>0);

        int expectedDanceMoveDefinitionsCount = dmdFilesFolder.listFiles().length;

        DanceMoveDefinitionsParser parser = new DanceMoveDefinitionsParser();
        List<DanceMoveDefinition> danceMoveDefinitions = parser.parseDefinitionFiles(dmdFilesFolder);

        assertEquals(expectedDanceMoveDefinitionsCount, danceMoveDefinitions.size());
    }

    @Test
    public void testParseSingleDefinitionFile() throws IOException {
        File dmdFile = copyToTemp("/definitions/HeelHeel.dmd");

        DanceMoveDefinitionsParser parser = new DanceMoveDefinitionsParser();
        List<DanceMoveDefinition> danceMoveDefinitions = parser.parseSingleDefinitionFile(dmdFile);

        assertEquals(1, danceMoveDefinitions.size());
    }
}