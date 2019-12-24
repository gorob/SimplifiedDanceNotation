package com.gorob.simplified.dance.notation.model.dance;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter(AccessLevel.PRIVATE)
@EqualsAndHashCode
public class TimeSignature {
    private String signature;

    public TimeSignature(String signature){
        this.signature = signature;
    }

    protected int getBeatsCountInEachMeasure(){
        String[] split = getSignature().split("/");
        if (split==null || split.length!=2 || split[0]==null || parseIntValue(split[0])==null){
            throw new RuntimeException("TimeSignature not parsable!");
        }
        return parseIntValue(split[0]);
    }

    protected int getNoteValueForOneBeat(){
        String[] split = getSignature().split("/");
        if (split==null || split.length!=2 || split[1]==null || parseIntValue(split[1])==null){
            throw new RuntimeException("TimeSignature not parsable!");
        }
        return parseIntValue(split[1]);
    }

    private Integer parseIntValue(String strValue){
        try {
            return Integer.parseInt(strValue.trim());
        } catch (Exception ex) {
            return null;
        }
    }
}
