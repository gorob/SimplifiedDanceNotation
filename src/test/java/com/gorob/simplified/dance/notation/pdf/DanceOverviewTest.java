package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DanceOverviewTest extends AbstractTest {
    @Test
    public void testCreate(){
        DanceOverview danceOverview = getTmc().createDefaultDanceOverview();
        assertEquals(getTmc().createDefaultDance(), danceOverview.getDance());
    }

    @Test
    public void testGetTitle() {
        DanceOverview danceOverview = getTmc().createDefaultDanceOverview();
        assertEquals("Shout Shout (2 Wall, 32 Count)", danceOverview.getTitle());
    }

    @Test
    public void testGetChoreographyTitle(){
        DanceOverview danceOverview = getTmc().createDefaultDanceOverview();
        assertEquals("Choreographie: Yvonne Zielonka (2013)", danceOverview.getChoreographyTitle());
    }

    @Test
    public void testGetChoreographyMediaRefs(){
        DanceOverview danceOverview = getTmc().createDefaultDanceOverview();
        List<String> choreographyMediaRefs = danceOverview.getChoreographyMediaRefs();
        assertEquals(1, choreographyMediaRefs.size());
        assertEquals("   => Youtube: https://www.youtube.com/watch?v=rouN3dS0A60", choreographyMediaRefs.get(0));
    }

    @Test
    public void testGetMusicTitle(){
        DanceOverview danceOverview = getTmc().createDefaultDanceOverview();
        assertEquals("Musik: Shout Shout (Knock Yourself Out) von Rocky Sharpe & The Replays (2013)", danceOverview.getMusicTitle());
    }

    @Test
    public void testGetMusicMediaRefs(){
        DanceOverview danceOverview = getTmc().createDefaultDanceOverview();
        List<String> musicMediaRefs = danceOverview.getMusicMediaRefs();
        assertEquals(1, musicMediaRefs.size());
        assertEquals("   => Amazon Music: https://music.amazon.de/albums/B00AVH7D0M?trackAsin=B00AVH7H2Q&amp;ref=dm_sh_Ez04ftdT9VtzX7rxs97sOMqlH", musicMediaRefs.get(0));
    }

}