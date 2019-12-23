package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.MovementAttributes;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyPartMovementInstructionTextTest extends AbstractTest {
    private Messages createMessagesGerman(){
        return createMessages("de", "DE");
    }

    private Messages createMessagesEnglish(){
        return createMessages("en", "US");
    }

    private Messages createMessages(String userLanguage, String userCountry){
        return new Messages(){
            @Override
            protected String getUserLanguage() {
                return userLanguage;
            }

            @Override
            protected String getUserCountry() {
                return userCountry;
            }
        };
    }

    @Test
    public void testGetInstructionText_german(){
        Messages messages = createMessagesGerman();

        BodyPartMovementInstructionText instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createDefaultBodyPartMovementXY(), messages);
        assertEquals("RF Schritt nach vorne (am Ende Fuß über dem Boden)", instructionText.getInstructionText());

        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createDefaultBodyPartMovementXY_2(), messages);
        assertEquals("LF 1/4 Drehung nach links (am Ende Gewicht auf dem Ballen)", instructionText.getInstructionText());

        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createDefaultBodyPartMovementXY_3(), messages);
        assertEquals("RF großer Schritt im Kreis nach hinten (am Ende Gewicht auf gesamtem Fuß)", instructionText.getInstructionText());

        MovementAttributes movementAttributesXY = getTmc().createMovementAttributes(Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE);
        MovementAttributes movementAttributesZ = getTmc().createDefaultMovementAttributesZ_none();
        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.TAP_HEEL), messages);
        assertEquals("RF Schritt nach rechts vorne und mit Ferse auftippen", instructionText.getInstructionText());
    }

    @Test
    public void testGetInstructionText_english(){
        Messages messages = createMessagesEnglish();

        BodyPartMovementInstructionText instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createDefaultBodyPartMovementXY(), messages);
        assertEquals("RF step forward (at the end raised foot)", instructionText.getInstructionText());

        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createDefaultBodyPartMovementXY_2(), messages);
        assertEquals("LF 1/4 turn left (at the end weight on ball)", instructionText.getInstructionText());

        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createDefaultBodyPartMovementXY_3(), messages);
        assertEquals("RF large step within an arc backward (at the end weight on whole foot)", instructionText.getInstructionText());

        MovementAttributes movementAttributesXY = getTmc().createMovementAttributes(Direction.RIGHT_FORWARD, Course.LINEAR, Distance.MEDIUM, Rotation.NONE);
        MovementAttributes movementAttributesZ = getTmc().createDefaultMovementAttributesZ_none();
        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.TAP_HEEL), messages);
        assertEquals("RF step right forward and tap with heel", instructionText.getInstructionText());
    }
}