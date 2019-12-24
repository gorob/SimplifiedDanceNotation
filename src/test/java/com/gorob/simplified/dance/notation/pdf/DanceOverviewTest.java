package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.AbstractTest;
import com.gorob.simplified.dance.notation.messages.Messages;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DanceOverviewTest extends AbstractTest {
    private DanceOverview createUnderTest(){
        Messages messages = getTmc().createMessagesEnglish();
        return getTmc().createDefaultDanceOverview(messages);
    }

    @Test
    public void testCreate(){
        DanceOverview danceOverview = createUnderTest();
        assertEquals(getTmc().createDefaultDance(), danceOverview.getDance());
    }

    @Test
    public void testGetTitle() {
        DanceOverview danceOverview = createUnderTest();
        assertEquals("Shout Shout (2 Wall, 32 Count)", danceOverview.getTitle());
    }

    @Test
    public void testGetChoreographyTitle(){
        DanceOverview danceOverview = createUnderTest();
        assertEquals("Choreographie: Yvonne Zielonka (2013)", danceOverview.getChoreographyTitle());
    }

    @Test
    public void testGetChoreographyMediaRefs(){
        DanceOverview danceOverview = createUnderTest();
        List<String> choreographyMediaRefs = danceOverview.getChoreographyMediaRefs();
        assertEquals(1, choreographyMediaRefs.size());
        assertEquals("   => Youtube: https://www.youtube.com/watch?v=rouN3dS0A60", choreographyMediaRefs.get(0));
    }

    @Test
    public void testGetMusicTitle(){
        DanceOverview danceOverview = createUnderTest();
        assertEquals("Musik: Shout Shout (Knock Yourself Out) von Rocky Sharpe & The Replays (2013)", danceOverview.getMusicTitle());
    }

    @Test
    public void testGetMusicMediaRefs(){
        DanceOverview danceOverview = createUnderTest();
        List<String> musicMediaRefs = danceOverview.getMusicMediaRefs();
        assertEquals(1, musicMediaRefs.size());
        assertEquals("   => Amazon Music: https://music.amazon.de/albums/B00AVH7D0M?trackAsin=B00AVH7H2Q&amp;ref=dm_sh_Ez04ftdT9VtzX7rxs97sOMqlH", musicMediaRefs.get(0));
    }
}