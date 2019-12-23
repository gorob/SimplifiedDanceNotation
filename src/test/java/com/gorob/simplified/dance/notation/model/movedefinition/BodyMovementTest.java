package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyMovementTest extends AbstractTest {
    @Test
    public void testCreate(){
        BodyMovement bodyMovement = getTmc().createBodyMovement();
        assertTrue(bodyMovement.getBodyPartMovements().isEmpty());
    }

    @Test
    public void testAddMovementPart(){
        BodyMovement bodyMovement = getTmc().createBodyMovement();
        assertEquals(0, bodyMovement.getBodyPartMovements().size());

        BodyPartMovement defaultBodyPartMovementXY = getTmc().createDefaultBodyPartMovementXY();
        bodyMovement.addBodyPartMovement(defaultBodyPartMovementXY);
        assertEquals(1, bodyMovement.getBodyPartMovements().size());
        assertSame(defaultBodyPartMovementXY, bodyMovement.getBodyPartMovements().get(0));

        BodyPartMovement defaultBodyPartMovementXY_2 = getTmc().createDefaultBodyPartMovementXY_2();
        bodyMovement.addBodyPartMovement(defaultBodyPartMovementXY_2);
        assertEquals(2, bodyMovement.getBodyPartMovements().size());
        assertSame(defaultBodyPartMovementXY, bodyMovement.getBodyPartMovements().get(0));
        assertSame(defaultBodyPartMovementXY_2, bodyMovement.getBodyPartMovements().get(1));
    }
}