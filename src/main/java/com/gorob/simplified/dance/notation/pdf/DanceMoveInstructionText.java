package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.TimeSignature;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovementGroup;
import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveVariantDefinition;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
public class DanceMoveInstructionText extends AbstractInstructionText {
    private DanceMoveVariantDefinition danceMoveVariantDefinition;
    private TimeSignature timeSignature;

    public DanceMoveInstructionText(DanceMoveVariantDefinition danceMoveVariantDefinition, TimeSignature timeSignature, Messages messages){
        super(messages);
        this.danceMoveVariantDefinition = danceMoveVariantDefinition;
        this.timeSignature = timeSignature;
    }

    public String getDanceMoveName(){
        return getDanceMoveVariantDefinition().getDefaultName();
    }

    public List<BodyMovementGroupInstructionText> getBodyMovementGroupInstructionTexts() {
        return getDanceMoveVariantDefinition().getBodyMovementGroups().stream().map(bodyMovementGroup -> new BodyMovementGroupInstructionText(bodyMovementGroup, getTimeSignature(), getMessages())).collect(Collectors.toList());
    }

}
