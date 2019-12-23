package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class DanceMoveDefinitionTest extends AbstractTest {
    @Test
    public void testCreate(){
        DanceMoveDefinition danceMoveDefinition = getTmc().createDefaultDanceMoveDefinition();
        assertEquals("DanceMoveDefinitionId", danceMoveDefinition.getId());
        assertEquals("DanceMoveDefinitionName", danceMoveDefinition.getDefaultName());
        assertTrue(danceMoveDefinition.getDanceMoveVariantDefinitions().isEmpty());
    }

    @Test
    public void testAddDanceMoveVariantDefinition(){
        DanceMoveDefinition danceMoveDefinition = getTmc().createDefaultDanceMoveDefinition();
        assertTrue(danceMoveDefinition.getDanceMoveVariantDefinitions().isEmpty());

        DanceMoveVariantDefinition danceMoveVariantDefinition1 = getTmc().createDefaultDanceMoveVariantDefinition(getTmc().createBodyMovementGroup(1, getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY())));
        danceMoveDefinition.addDanceMoveVariantDefinition(danceMoveVariantDefinition1);
        assertEquals(1, danceMoveDefinition.getDanceMoveVariantDefinitions().size());
        assertSame(danceMoveVariantDefinition1, danceMoveDefinition.getDanceMoveVariantDefinitions().get(0));

        DanceMoveVariantDefinition danceMoveVariantDefinition2 = getTmc().createDefaultDanceMoveVariantDefinition(getTmc().createBodyMovementGroup(2, getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY())));
        danceMoveDefinition.addDanceMoveVariantDefinition(danceMoveVariantDefinition2);
        assertEquals(2, danceMoveDefinition.getDanceMoveVariantDefinitions().size());
        assertSame(danceMoveVariantDefinition1, danceMoveDefinition.getDanceMoveVariantDefinitions().get(0));
        assertSame(danceMoveVariantDefinition2, danceMoveDefinition.getDanceMoveVariantDefinitions().get(1));
    }
}