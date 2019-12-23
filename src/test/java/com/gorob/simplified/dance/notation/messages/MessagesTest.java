package com.gorob.simplified.dance.notation.messages;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessagesTest {
    private Messages createUnderTestGerman(){
        return createUnderTest("de", "DE");
    }

    private Messages createUnderTestEnglish(){
        return createUnderTest("en", "US");
    }

    private Messages createUnderTest(String userLanguage, String userCountry){
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
    public void testCreate(){
        Messages messages = createUnderTestEnglish();
        assertNotNull(messages.getMessageBundle());
    }

    @Test
    public void testGetMessage_german(){
        Messages messages = createUnderTestGerman();
        assertEquals("kleiner Schritt", messages.getMessage("DISTANCE_SMALL"));
        assertEquals("großer Schritt", messages.getMessage("DISTANCE_LARGE"));
    }

    @Test
    public void testGetMessage_english(){
        Messages messages = createUnderTestEnglish();
        assertEquals("small step", messages.getMessage("DISTANCE_SMALL"));
        assertEquals("large step", messages.getMessage("DISTANCE_LARGE"));
    }

    @Test
    public void testGetMessage_languageAndCountryEmpty_messagesFileWithoutLanguageAndCountryRead(){
        Messages messages = createUnderTest("", "");
        assertEquals("kleiner Schritt", messages.getMessage("DISTANCE_SMALL"));
        assertEquals("großer Schritt", messages.getMessage("DISTANCE_LARGE"));
    }

    @Test
    public void testGetMessage_languageAndCountryUnknown_messagesFileForDefaultLocaleOfJavaRead(){
        Messages messages = createUnderTest("en", "GB");

        Messages messagesDefault = new Messages();

        assertEquals(messagesDefault.getMessage("DISTANCE_SMALL"), messages.getMessage("DISTANCE_SMALL"));
        assertEquals(messagesDefault.getMessage("DISTANCE_LARGE"), messages.getMessage("DISTANCE_LARGE"));
    }
}