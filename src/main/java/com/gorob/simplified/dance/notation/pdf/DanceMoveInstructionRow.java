package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveVariantDefinition;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PROTECTED)
public class DanceMoveInstructionRow {
    private DanceMoveVariantDefinition danceMoveVariantDefinition;
    private String timeSignature;

    public DanceMoveInstructionRow(DanceMoveVariantDefinition danceMoveVariantDefinition, String timeSignature){
        this.danceMoveVariantDefinition = danceMoveVariantDefinition;
        this.timeSignature = timeSignature;
    }

    protected int getBeatsCountInEachMeasure(){
        String[] split = getTimeSignature().split("/");
        if (split==null || split.length!=2 || split[0]==null || parseIntValue(split[0])==null){
            throw new RuntimeException("TimeSignature not parsable!");
        }
        return parseIntValue(split[0]);
    }

    protected int getNoteValueForOneBeat(){
        String[] split = getTimeSignature().split("/");
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
