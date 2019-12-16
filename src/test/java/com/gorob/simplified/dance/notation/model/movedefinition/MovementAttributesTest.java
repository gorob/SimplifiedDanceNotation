package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Course;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Direction;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Distance;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Rotation;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovementAttributesTest extends AbstractTest {
    @Test
    public void testCreate(){
        MovementAttributes movementAttributes = getTmc().createDefaultMovementAttributesXY();
        assertEquals(Direction.FORWARD, movementAttributes.getDirection());
        assertEquals(Course.LINEAR, movementAttributes.getCourse());
        assertEquals(Distance.MEDIUM, movementAttributes.getDistance());
        assertEquals(Rotation.NONE, movementAttributes.getRotation());
    }
}