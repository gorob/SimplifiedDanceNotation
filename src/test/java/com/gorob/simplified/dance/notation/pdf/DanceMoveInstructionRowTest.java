package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.model.dance.Dance;
import org.junit.Test;

import static org.junit.Assert.*;

public class DanceMoveInstructionRowTest extends AbstractTest {
    @Test
    public void testGetBeatsCountInEachMeasure(){
        Dance dance = getTmc().createDefaultDance();

        DanceMoveInstructionRow row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), "3/4");
        assertEquals(3, row.getBeatsCountInEachMeasure());

        row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 3 / 4 ");
        assertEquals(3, row.getBeatsCountInEachMeasure());

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), "/ 4 ");
            row.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 4 ");
            row.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), "a/ 4 ");
            row.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), "4a/ 4 ");
            row.getBeatsCountInEachMeasure();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }
    }

    @Test
    public void testGetNoteValueForOneBeat(){
        Dance dance = getTmc().createDefaultDance();

        DanceMoveInstructionRow row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), "3/4");
        assertEquals(4, row.getNoteValueForOneBeat());

        row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 3 / 4 ");
        assertEquals(4, row.getNoteValueForOneBeat());

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 4 /");
            row.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 4 ");
            row.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 4 /a");
            row.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }

        try {
            row = new DanceMoveInstructionRow(dance.getDanceMoves().get(0), " 4 /4a");
            row.getNoteValueForOneBeat();
            fail("Exception expected!");
        } catch (RuntimeException ex) {
            assertEquals("TimeSignature not parsable!", ex.getMessage());
        }
    }
}