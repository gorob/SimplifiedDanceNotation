package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovementGroup;
import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveVariantDefinition;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
public class DanceMoveInstructionText extends AbstractInstructionText {
    private DanceMoveVariantDefinition danceMoveVariantDefinition;
    private String timeSignature;

    public DanceMoveInstructionText(DanceMoveVariantDefinition danceMoveVariantDefinition, String timeSignature, Messages messages){
        super(messages);
        this.danceMoveVariantDefinition = danceMoveVariantDefinition;
        this.timeSignature = timeSignature;
    }

    public List<BodyMovementGroupInstructionText> getBodyMovementGroupInstructionTexts() {
        return getDanceMoveVariantDefinition().getBodyMovementGroups().stream().map(bodyMovementGroup -> new BodyMovementGroupInstructionText(bodyMovementGroup, getMessages())).collect(Collectors.toList());
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
