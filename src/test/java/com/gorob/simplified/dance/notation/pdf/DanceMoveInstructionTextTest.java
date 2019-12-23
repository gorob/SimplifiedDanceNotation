package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.Dance;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Distance;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DanceMoveInstructionTextTest extends AbstractTest {
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
    public void testGetBeatsCountInEachMeasure(){
        Messages messages = createMessagesEnglish();
        Dance dance = getTmc().createDefaultDance();

        DanceMoveInstructionText danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), "3/4", messages);
        assertEquals(3, danceMoveInstructionText.getBeatsCountInEachMeasure());

        danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 3 / 4 ", messages);
        assertEquals(3, danceMoveInstructionText.getBeatsCountInEachMeasure());

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), "/ 4 ", messages);
            danceMoveInstructionText.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 4 ", messages);
            danceMoveInstructionText.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), "a/ 4 ", messages);
            danceMoveInstructionText.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), "4a/ 4 ", messages);
            danceMoveInstructionText.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }
    }

    @Test
    public void testGetNoteValueForOneBeat(){
        Messages messages = createMessagesEnglish();
        Dance dance = getTmc().createDefaultDance();

        DanceMoveInstructionText danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), "3/4", messages);
        assertEquals(4, danceMoveInstructionText.getNoteValueForOneBeat());

        danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 3 / 4 ", messages);
        assertEquals(4, danceMoveInstructionText.getNoteValueForOneBeat());

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 4 /", messages);
            danceMoveInstructionText.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 4 ", messages);
            danceMoveInstructionText.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 4 /a", messages);
            danceMoveInstructionText.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), " 4 /4a", messages);
            danceMoveInstructionText.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }
    }

    @Test
    public void testGetBodyMovementGroupInstructionTexts(){
        Messages messages = createMessagesEnglish();
        Dance dance = getTmc().createDefaultDance();

        DanceMoveInstructionText danceMoveInstructionText = new DanceMoveInstructionText(dance.getDanceMoves().get(0), "3/4", messages);

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