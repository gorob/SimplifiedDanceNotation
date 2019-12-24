package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.Dance;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Distance;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DanceMoveInstructionTextTest extends AbstractTest {
    @Test
    public void testGetBodyMovementGroupInstructionTexts(){
        Messages messages = getTmc().createMessagesEnglish();
        Dance dance = getTmc().createDefaultDance();

        DanceMoveInstructionText danceMoveInstructionText = getTmc().createDanceMoveInstructionText(dance.getDanceMoves().get(0), getTmc().createTimeSignature("3/4"), messages);

        List<BodyMovementGroupInstructionText> bodyMovementGroupInstructionTexts = danceMoveInstructionText.getBodyMovementGroupInstructionTexts();
        assertEquals(2, bodyMovementGroupInstructionTexts.size());

        assertEquals(2, bodyMovementGroupInstructionTexts.get(0).getBodyMovementInstructionTexts().size());

        assertEquals(3, bodyMovementGroupInstructionTexts.get(0).getBodyMovementInstructionTexts().get(0).getBodyPartMovementInstructionTexts().size());
        assertEquals(3, bodyMovementGroupInstructionTexts.get(0).getBodyMovementInstructionTexts().get(1).getBodyPartMovementInstructionTexts().size());

        assertEquals(2, bodyMovementGroupInstructionTexts.get(1).getBodyMovementInstructionTexts().size());

        assertEquals(3, bodyMovementGroupInstructionTexts.get(1).getBodyMovementInstructionTexts().get(0).getBodyPartMovementInstructionTexts().size());
        assertEquals(3, bodyMovementGroupInstructionTexts.get(1).getBodyMovementInstructionTexts().get(1).getBodyPartMovementInstructionTexts().size());
    }
}