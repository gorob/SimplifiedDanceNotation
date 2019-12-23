package com.gorob.simplified.dance.notation.messages;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Locale;
import java.util.ResourceBundle;

@Getter(AccessLevel.PROTECTED)
public class Messages {
    private static final String MESSAGES_ROOT_NAME = "messages";
    private static final String LOCALE_USER_LANGUAGE_ENV_NAME = "user.language";
    private static final String LOCALE_USER_COUNTRY_ENV_NAME = "user.country";

    private ResourceBundle messageBundle;

    public Messages(){
        this.initMessageBundle();
    }

    public String getMessage(String key){
        return getMessageBundle().getString(key);
    }

    protected void initMessageBundle(){
        this.messageBundle = ResourceBundle.getBundle(MESSAGES_ROOT_NAME, createLocale());
    }

    protected Locale createLocale(){
        return new Locale(getUserLanguage(), getUserCountry());
    }

    protected String getUserLanguage(){
        return System.getProperty(LOCALE_USER_LANGUAGE_ENV_NAME);
    }

    protected String getUserCountry(){
        return System.getProperty(LOCALE_USER_COUNTRY_ENV_NAME);
    }
}
