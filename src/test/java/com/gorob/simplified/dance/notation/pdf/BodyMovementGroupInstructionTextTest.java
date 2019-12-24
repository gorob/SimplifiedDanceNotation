package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovementGroup;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyMovementGroupInstructionTextTest extends AbstractTest {
    @Test
    public void testGetBodyMovementInstructionTexts(){
        Messages messages = getTmc().createMessagesEnglish();

        BodyMovement bodyMovement1 = getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY(), getTmc().createDefaultBodyPartMovementXY_2());
        BodyMovement bodyMovement2 = getTmc().createBodyMovement(getTmc().createDefaultBodyPartMovementXY_3());
        BodyMovementGroup bodyMovementGroup = getTmc().createBodyMovementGroup(2, bodyMovement1, bodyMovement2);
        BodyMovementGroupInstructionText bodyMovementGroupInstructionText = getTmc().createBodyMovementGroupInstructionText(bodyMovementGroup, messages);

        assertEquals(2, bodyMovementGroupInstructionText.getBodyMovementInstructionTexts().size());

        BodyMovementInstructionText bodyMovementInstructionText = bodyMovementGroupInstructionText.getBodyMovementInstructionTexts().get(0);
        assertEquals(2, bodyMovementInstructionText.getBodyPartMovementInstructionTexts().size());
        assertEquals("RF step forward (at the end raised foot)", bodyMovementInstructionText.getBodyPartMovementInstructionTexts().get(0).getInstructionText());
        assertEquals("LF 1/4 turn left (at the end weight on ball)", bodyMovementInstructionText.getBodyPartMovementInstructionTexts().get(1).getInstructionText());

        bodyMovementInstructionText = bodyMovementGroupInstructionText.getBodyMovementInstructionTexts().get(1);
        assertEquals(1, bodyMovementInstructionText.getBodyPartMovementInstructionTexts().size());
        assertEquals("RF large step within an arc backward (at the end weight on whole foot)", bodyMovementInstructionText.getBodyPartMovementInstructionTexts().get(0).getInstructionText());
    }
}