package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.MovementAttributes;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BodyPartMovementInstructionTextTest extends AbstractTest {

    @Test
    public void testGetInstructionText_german(){
        Messages messages = getTmc().createMessagesGerman();
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

        movementAttributesXY = getTmc().createMovementAttributes(Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE);
        movementAttributesZ = getTmc().createDefaultMovementAttributesZ_none();
        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED), messages);
        assertEquals("RF heranziehen (am Ende Fuß über dem Boden)", instructionText.getInstructionText());

        movementAttributesXY = getTmc().createMovementAttributes(Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE);
        movementAttributesZ = getTmc().createDefaultMovementAttributesZ_none();
        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.ON_WHOLE), messages);
        assertEquals("RF heransetzen (am Ende Gewicht auf gesamtem Fuß)", instructionText.getInstructionText());
    }

    @Test
    public void testGetInstructionText_english(){
        Messages messages = getTmc().createMessagesEnglish();

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

        movementAttributesXY = getTmc().createMovementAttributes(Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE);
        movementAttributesZ = getTmc().createDefaultMovementAttributesZ_none();
        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.RAISED), messages);
        assertEquals("RF close to body (at the end raised foot)", instructionText.getInstructionText());

        movementAttributesXY = getTmc().createMovementAttributes(Direction.CLOSE, Course.LINEAR, Distance.NONE, Rotation.NONE);
        movementAttributesZ = getTmc().createDefaultMovementAttributesZ_none();
        instructionText = getTmc().createBodyPartMovementInstructionText(getTmc().createBodyPartMovement(BodyPart.RIGHT_FOOT, movementAttributesXY, movementAttributesZ, WeightOnFloor.ON_WHOLE), messages);
        assertEquals("RF close to body (at the end weight on whole foot)", instructionText.getInstructionText());
    }
}