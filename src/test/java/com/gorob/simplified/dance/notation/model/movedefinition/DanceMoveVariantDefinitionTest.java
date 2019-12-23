package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class DanceMoveVariantDefinitionTest extends AbstractTest {
    @Test
    public void testCreate(){
        DanceMoveVariantDefinition danceMoveVariantDefinition = getTmc().createDefaultDanceMoveVariantDefinition();
        assertEquals("DanceMoveDefinitionVariantId", danceMoveVariantDefinition.getId());
        assertEquals("DanceMoveDefinitionVariantName", danceMoveVariantDefinition.getDefaultName());
        assertTrue(danceMoveVariantDefinition.getBodyMovementGroups().isEmpty());
    }

    @Test
    public void testAddBodyMovement(){
        DanceMoveVariantDefinition danceMoveVariantDefinition = getTmc().createDefaultDanceMoveVariantDefinition();
        assertTrue(danceMoveVariantDefinition.getBodyMovementGroups().isEmpty());

        BodyMovementGroup bodyMovementGroup1 = getTmc().createBodyMovementGroup(1, getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY()));
        danceMoveVariantDefinition.addBodyMovementGroup(bodyMovementGroup1);
        assertEquals(1, danceMoveVariantDefinition.getBodyMovementGroups().size());
        assertSame(bodyMovementGroup1, danceMoveVariantDefinition.getBodyMovementGroups().get(0));

        BodyMovementGroup bodyMovementGroup2 = getTmc().createBodyMovementGroup(2, getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY()));
        danceMoveVariantDefinition.addBodyMovementGroup(bodyMovementGroup2);
        assertEquals(2, danceMoveVariantDefinition.getBodyMovementGroups().size());
        assertSame(bodyMovementGroup1, danceMoveVariantDefinition.getBodyMovementGroups().get(0));
        assertSame(bodyMovementGroup2, danceMoveVariantDefinition.getBodyMovementGroups().get(1));
    }
}