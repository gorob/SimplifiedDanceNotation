package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyMovementGroupTest extends AbstractTest {
    @Test
    public void testCreate(){
        BodyMovementGroup bodyMovementGroup = getTmc().createBodyMovementGroup(1);
        assertEquals(1, bodyMovementGroup.getCounts());
        assertTrue(bodyMovementGroup.getBodyMovements().isEmpty());
    }

    @Test
    public void testAddBodyMovement(){
        BodyMovementGroup bodyMovementGroup = getTmc().createBodyMovementGroup(1);
        assertEquals(0, bodyMovementGroup.getBodyMovements().size());

        BodyMovement bodyMovement1 = getTmc().createBodyMovement();
        BodyPartMovement defaultBodyPartMovementXY = getTmc().createDefaultBodyPartMovementXY();
        bodyMovement1.addBodyPartMovement(defaultBodyPartMovementXY);
        bodyMovementGroup.addBodyMovement(bodyMovement1);
        assertEquals(1, bodyMovement1.getBodyPartMovements().size());
        assertSame(bodyMovement1, bodyMovementGroup.getBodyMovements().get(0));

        BodyMovement bodyMovement2 = getTmc().createBodyMovement();
        BodyPartMovement defaultBodyPartMovementXY_2 = getTmc().createDefaultBodyPartMovementXY_2();
        bodyMovement2.addBodyPartMovement(defaultBodyPartMovementXY_2);
        bodyMovementGroup.addBodyMovement(bodyMovement2);
        assertEquals(2, bodyMovementGroup.getBodyMovements().size());
        assertSame(bodyMovement1, bodyMovementGroup.getBodyMovements().get(0));
        assertSame(bodyMovement2, bodyMovementGroup.getBodyMovements().get(1));
    }
}