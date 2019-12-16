package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class DanceMoveDefinitionsTest extends AbstractTest {
    private DanceMoveDefinitions createUnderTest() throws IOException {
        File dmdFilesFolder = copyFolderToTemp("/definitions", "dmdfiles");
        return new DanceMoveDefinitions(dmdFilesFolder);
    }

    @Test
    public void testCreate() throws IOException {
        DanceMoveDefinitions danceMoveDefinitions = createUnderTest();
        assertFalse(danceMoveDefinitions.getDanceMoveDefinitions().isEmpty());
    }

    @Test
    public void testGetDanceMoveVariantDefinitionIds() throws IOException {
        DanceMoveDefinitions danceMoveDefinitions = createUnderTest();
        assertEquals(13, danceMoveDefinitions.getDanceMoveVariantDefinitionIds().size());
    }

    @Test
    public void testGetDanceMoveVariantDefinitionById() throws IOException {
        DanceMoveDefinitions danceMoveDefinitions = createUnderTest();

        danceMoveDefinitions.getDanceMoveVariantDefinitionIds().forEach(danceMoveVariantDefinitionId -> {
            assertNotNull(danceMoveDefinitions.getDanceMoveVariantDefinitionById(danceMoveVariantDefinitionId));
        });

        assertNull(danceMoveDefinitions.getDanceMoveVariantDefinitionById("idWhichDoesNotExist"));
    }
}