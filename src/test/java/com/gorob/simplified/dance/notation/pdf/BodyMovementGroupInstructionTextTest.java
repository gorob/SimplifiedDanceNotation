package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.TimeSignature;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovementGroup;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyMovementGroupInstructionTextTest extends AbstractTest {
    private BodyMovementGroupInstructionText createUnderTest(int counts, TimeSignature timeSignature){
        Messages messages = getTmc().createMessagesEnglish();
        BodyMovement bodyMovement1 = getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY(), getTmc().createDefaultBodyPartMovementXY_2());
        BodyMovement bodyMovement2 = getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY_3());
        BodyMovementGroup bodyMovementGroup = getTmc().createBodyMovementGroup(counts, bodyMovement1, bodyMovement2);
        return getTmc().createBodyMovementGroupInstructionText(bodyMovementGroup, timeSignature, messages);
    }

    @Test
    public void testGetBodyMovementInstructionTexts(){
        BodyMovementGroupInstructionText bodyMovementGroupInstructionText = createUnderTest(2, getTmc().createDefaultTimeSignature());

        assertEquals(2, bodyMovementGroupInstructionText.getBodyMovementInstructionTexts().size());

        BodyMovementInstructionText bodyMovementInstructionText = bodyMovementGroupInstructionText.getBodyMovementInstructionTexts().get(0);
        assertEquals(2, bodyMovementInstructionText.getBodyPartMovementInstructionTexts().size());
        assertEquals("RF step forward (at the end raised foot)", bodyMovementInstructionText.getBodyPartMovementInstructionTexts().get(0).getInstructionText());
        assertEquals("LF 1/4 turn left (at the end weight on ball)", bodyMovementInstructionText.getBodyPartMovementInstructionTexts().get(1).getInstructionText());

        bodyMovementInstructionText = bodyMovementGroupInstructionText.getBodyMovementInstructionTexts().get(1);
        assertEquals(1, bodyMovementInstructionText.getBodyPartMovementInstructionTexts().size());
        assertEquals("RF large step within an arc backward (at the end weight on whole foot)", bodyMovementInstructionText.getBodyPartMovementInstructionTexts().get(0).getInstructionText());
    }

    @Test
    public void testGetTimeLength(){
        TimeSignature timeSignature = getTmc().createDefaultTimeSignature();

        BodyMovementGroupInstructionText bodyMovementGroupInstructionText = createUnderTest(1, timeSignature);
        assertEquals(Double.valueOf(0.25), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));

        bodyMovementGroupInstructionText = createUnderTest(2, timeSignature);
        assertEquals(Double.valueOf(0.5), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));

        bodyMovementGroupInstructionText = createUnderTest(3, timeSignature);
        assertEquals(Double.valueOf(0.75), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));

        bodyMovementGroupInstructionText = createUnderTest(4, timeSignature);
        assertEquals(Double.valueOf(1.0), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));


        timeSignature = getTmc().createTimeSignature("6/8");

        bodyMovementGroupInstructionText = createUnderTest(1, timeSignature);
        assertEquals(Double.valueOf(0.125), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));

        bodyMovementGroupInstructionText = createUnderTest(2, timeSignature);
        assertEquals(Double.valueOf(0.25), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));

        bodyMovementGroupInstructionText = createUnderTest(3, timeSignature);
        assertEquals(Double.valueOf(0.375), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));

        bodyMovementGroupInstructionText = createUnderTest(4, timeSignature);
        assertEquals(Double.valueOf(0.5), Double.valueOf(bodyMovementGroupInstructionText.getTimeLength()));
    }

    @Test
    public void testGetTimeLengthEachMovement(){
        TimeSignature timeSignature = getTmc().createDefaultTimeSignature();

        BodyMovementGroupInstructionText bodyMovementGroupInstructionText = createUnderTest(1, timeSignature);
        assertEquals(Double.valueOf(0.125), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));

        bodyMovementGroupInstructionText = createUnderTest(2, timeSignature);
        assertEquals(Double.valueOf(0.25), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));

        bodyMovementGroupInstructionText = createUnderTest(3, timeSignature);
        assertEquals(Double.valueOf(0.375), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));

        bodyMovementGroupInstructionText = createUnderTest(4, timeSignature);
        assertEquals(Double.valueOf(0.5), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));


        timeSignature = getTmc().createTimeSignature("6/8");

        bodyMovementGroupInstructionText = createUnderTest(1, timeSignature);
        assertEquals(Double.valueOf(0.0625), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));

        bodyMovementGroupInstructionText = createUnderTest(2, timeSignature);
        assertEquals(Double.valueOf(0.125), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));

        bodyMovementGroupInstructionText = createUnderTest(3, timeSignature);
        assertEquals(Double.valueOf(0.1875), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));

        bodyMovementGroupInstructionText = createUnderTest(4, timeSignature);
        assertEquals(Double.valueOf(0.25), Double.valueOf(bodyMovementGroupInstructionText.getTimeLengthEachMovement()));
    }

    @Test
    public void testIsCountingEightsNotes(){
        TimeSignature timeSignature = getTmc().createDefaultTimeSignature();

        BodyMovementGroupInstructionText bodyMovementGroupInstructionText = createUnderTest(1, timeSignature);
        assertTrue(bodyMovementGroupInstructionText.isCountingEightsNotes());

        bodyMovementGroupInstructionText = createUnderTest(2, timeSignature);
        assertFalse(bodyMovementGroupInstructionText.isCountingEightsNotes());

        bodyMovementGroupInstructionText = createUnderTest(3, timeSignature);
        assertFalse(bodyMovementGroupInstructionText.isCountingEightsNotes());
    }

    @Test
    public void testIsCountingQuarterNotes(){
        TimeSignature timeSignature = getTmc().createDefaultTimeSignature();

        BodyMovementGroupInstructionText bodyMovementGroupInstructionText = createUnderTest(1, timeSignature);
        assertFalse(bodyMovementGroupInstructionText.isCountingQuarterNotes());

        bodyMovementGroupInstructionText = createUnderTest(2, timeSignature);
        assertTrue(bodyMovementGroupInstructionText.isCountingQuarterNotes());

        bodyMovementGroupInstructionText = createUnderTest(3, timeSignature);
        assertFalse(bodyMovementGroupInstructionText.isCountingQuarterNotes());
    }

}