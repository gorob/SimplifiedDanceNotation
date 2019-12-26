package com.gorob.simplified.dance.notation.messages;

import com.gorob.simplified.dance.notation.model.movedefinition.enums.BodyPart;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Distance;
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
        assertEquals("kleiner Schritt", messages.getMessage(Distance.class.getSimpleName().toUpperCase() + "_" + Distance.SMALL.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT"));
        assertEquals("großer Schritt", messages.getMessage(Distance.class.getSimpleName().toUpperCase() + "_" + Distance.LARGE.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT"));
    }

    @Test
    public void testGetMessage_english(){
        Messages messages = createUnderTestEnglish();
        assertEquals("small step", messages.getMessage(Distance.class.getSimpleName().toUpperCase() + "_" + Distance.SMALL.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT"));
        assertEquals("large step", messages.getMessage(Distance.class.getSimpleName().toUpperCase() + "_" + Distance.LARGE.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT"));
    }

    @Test
    public void testGetMessage_languageAndCountryEmpty_messagesFileWithoutLanguageAndCountryRead(){
        Messages messages = createUnderTest("", "");
        assertEquals("kleiner Schritt", messages.getMessage(Distance.class.getSimpleName().toUpperCase() + "_" + Distance.SMALL.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT"));
        assertEquals("großer Schritt", messages.getMessage(Distance.class.getSimpleName().toUpperCase() + "_" + Distance.LARGE.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT"));
    }

    @Test
    public void testGetMessage_languageAndCountryUnknown_messagesFileForDefaultLocaleOfJavaRead(){
        Messages messages = createUnderTest("en", "GB");

        Messages messagesDefault = new Messages();

        String keyDistanceSmall = Distance.class.getSimpleName().toUpperCase() + "_" + Distance.SMALL.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT";
        String keyDistanceLarge = Distance.class.getSimpleName().toUpperCase() + "_" + Distance.SMALL.name() + "_" + BodyPart.class.getSimpleName().toUpperCase() + "_FOOT";
        assertEquals(messagesDefault.getMessage(keyDistanceSmall), messages.getMessage(keyDistanceSmall));
        assertEquals(messagesDefault.getMessage(keyDistanceLarge), messages.getMessage(keyDistanceLarge));
    }
}