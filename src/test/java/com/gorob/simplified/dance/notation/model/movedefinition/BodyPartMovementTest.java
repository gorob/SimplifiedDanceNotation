package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyPartMovementTest extends AbstractTest {
    @Test
    public void testCreate(){
        BodyPartMovement movement = getTmc().createDefaultBodyPartMovementXY();

        assertEquals(BodyPart.RIGHT_FOOT, movement.getBodyPart());
        assertEquals(getTmc().createDefaultMovementAttributesXY(), movement.getMovementAttributesXY());
        assertEquals(getTmc().createDefaultMovementAttributesZ_none(), movement.getMovementAttributesZ());
        assertEquals(WeightOnFloor.RAISED, movement.getWeightOnFloorEnd());
    }
}