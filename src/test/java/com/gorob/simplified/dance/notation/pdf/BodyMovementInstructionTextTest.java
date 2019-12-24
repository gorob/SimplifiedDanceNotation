package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.MovementAttributes;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyMovementInstructionTextTest extends AbstractTest {
    @Test
    public void testGetBodyPartMovementInstructionTexts(){
        Messages messages = getTmc().createMessagesEnglish();
        BodyMovementInstructionText instructionText = getTmc().createBodyMovementInstructionText(getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY(), getTmc().createDefaultBodyPartMovementXY_2(), getTmc().createDefaultBodyPartMovementXY_3()), messages);
        assertEquals(3, instructionText.getBodyPartMovementInstructionTexts().size());
        assertEquals("RF step forward (at the end raised foot)", instructionText.getBodyPartMovementInstructionTexts().get(0).getInstructionText());
        assertEquals("LF 1/4 turn left (at the end weight on ball)", instructionText.getBodyPartMovementInstructionTexts().get(1).getInstructionText());
        assertEquals("RF large step within an arc backward (at the end weight on whole foot)", instructionText.getBodyPartMovementInstructionTexts().get(2).getInstructionText());
    }
}