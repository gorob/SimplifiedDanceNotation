package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.IBodyMovement;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DanceMoveVariantDefinitionTest extends AbstractTest {
    @Test
    public void testCreate(){
        DanceMoveVariantDefinition danceMoveVariantDefinition = getTmc().createDefaultDanceMoveVariantDefinition();
        assertEquals("DanceMoveDefinitionVariantId", danceMoveVariantDefinition.getId());
        assertEquals("DanceMoveDefinitionVariantName", danceMoveVariantDefinition.getDefaultName());
        assertTrue(danceMoveVariantDefinition.getBodyMovements().isEmpty());
    }

    @Test
    public void testAddBodyMovement(){
        DanceMoveVariantDefinition danceMoveVariantDefinition = getTmc().createDefaultDanceMoveVariantDefinition();
        assertTrue(danceMoveVariantDefinition.getBodyMovements().isEmpty());

        BodyMovement bodyMovement1 = getTmc().createBodyMovement(1, getTmc().createDefaultBodyPartMovementXY());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement1);
        assertEquals(1, danceMoveVariantDefinition.getBodyMovements().size());
        assertSame(bodyMovement1, danceMoveVariantDefinition.getBodyMovements().get(0));

        BodyMovement bodyMovement2 = getTmc().createBodyMovement(2, getTmc().createDefaultBodyPartMovementXY());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement2);
        assertEquals(2, danceMoveVariantDefinition.getBodyMovements().size());
        assertSame(bodyMovement1, danceMoveVariantDefinition.getBodyMovements().get(0));
        assertSame(bodyMovement2, danceMoveVariantDefinition.getBodyMovements().get(1));
    }

    @Test
    public void testGetBodyMovementsForCount(){
        DanceMoveVariantDefinition danceMoveVariantDefinition = getTmc().createDefaultDanceMoveVariantDefinition();
        List<IBodyMovement> bodyMovementsForCount = danceMoveVariantDefinition.getBodyMovementsForCount(1);
        assertTrue(bodyMovementsForCount.isEmpty());

        BodyMovement bodyMovement1 = getTmc().createBodyMovement(1, getTmc().createDefaultBodyPartMovementXY());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement1);
        bodyMovementsForCount = danceMoveVariantDefinition.getBodyMovementsForCount(1);
        assertEquals(1, bodyMovementsForCount.size());
        assertSame(bodyMovement1, bodyMovementsForCount.get(0));

        BodyMovement bodyMovement2 = getTmc().createBodyMovement(2, getTmc().createDefaultBodyPartMovementXY_2());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement2);
        bodyMovementsForCount = danceMoveVariantDefinition.getBodyMovementsForCount(1);
        assertEquals(1, bodyMovementsForCount.size());
        assertSame(bodyMovement1, bodyMovementsForCount.get(0));

        BodyMovement bodyMovement3 = getTmc().createBodyMovement(1, getTmc().createDefaultBodyPartMovementXY_3());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement3);
        bodyMovementsForCount = danceMoveVariantDefinition.getBodyMovementsForCount(1);
        assertEquals(2, bodyMovementsForCount.size());
        assertSame(bodyMovement1, bodyMovementsForCount.get(0));
        assertSame(bodyMovement3, bodyMovementsForCount.get(1));

        BodyMovement bodyMovement4 = getTmc().createBodyMovement(2, getTmc().createDefaultBodyPartMovementZ());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement4);
        bodyMovementsForCount = danceMoveVariantDefinition.getBodyMovementsForCount(1);
        assertEquals(2, bodyMovementsForCount.size());
        assertSame(bodyMovement1, bodyMovementsForCount.get(0));
        assertSame(bodyMovement3, bodyMovementsForCount.get(1));

        BodyMovement bodyMovement5 = getTmc().createBodyMovement(1, getTmc().createDefaultBodyPartMovementZ_2());
        danceMoveVariantDefinition.addBodyMovement(bodyMovement5);
        bodyMovementsForCount = danceMoveVariantDefinition.getBodyMovementsForCount(1);
        assertEquals(3, bodyMovementsForCount.size());
        assertSame(bodyMovement1, bodyMovementsForCount.get(0));
        assertSame(bodyMovement3, bodyMovementsForCount.get(1));
        assertSame(bodyMovement5, bodyMovementsForCount.get(2));
    }
}