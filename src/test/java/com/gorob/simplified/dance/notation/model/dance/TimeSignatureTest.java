package com.gorob.simplified.dance.notation.model.dance;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.pdf.DanceMoveInstructionText;
import org.junit.Test;

import java.sql.Time;

import static org.junit.Assert.*;

public class TimeSignatureTest extends AbstractTest {
    @Test
    public void testGetBeatsCountInEachMeasure(){
        TimeSignature timeSignature = getTmc().createTimeSignature("3/4");
        assertEquals(3, timeSignature.getBeatsCountInEachMeasure());

        timeSignature = getTmc().createTimeSignature(" 3 / 4 ");
        assertEquals(3, timeSignature.getBeatsCountInEachMeasure());

        try {
            timeSignature = getTmc().createTimeSignature("/ 4 ");
            timeSignature.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            timeSignature = getTmc().createTimeSignature(" 4 ");
            timeSignature.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            timeSignature = getTmc().createTimeSignature("a/ 4 ");
            timeSignature.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            timeSignature = getTmc().createTimeSignature("4a/ 4 ");
            timeSignature.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }
    }

    @Test
    public void testGetNoteValueForOneBeat(){
        TimeSignature timeSignature = getTmc().createTimeSignature("3/4");
        assertEquals(4, timeSignature.getNoteValueForOneBeat());

        timeSignature = getTmc().createTimeSignature(" 3 / 4 ");
        assertEquals(4, timeSignature.getNoteValueForOneBeat());

        try {
            timeSignature = getTmc().createTimeSignature(" 4 /");
            timeSignature.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            timeSignature = getTmc().createTimeSignature(" 4 ");
            timeSignature.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            timeSignature = getTmc().createTimeSignature(" 4 /a");
            timeSignature.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            timeSignature = getTmc().createTimeSignature(" 4 /4a");
            timeSignature.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }
    }

}