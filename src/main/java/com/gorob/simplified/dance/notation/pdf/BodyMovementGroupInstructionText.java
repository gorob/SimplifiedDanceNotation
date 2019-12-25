package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.TimeSignature;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovementGroup;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PRIVATE)
public class BodyMovementGroupInstructionText extends AbstractInstructionText {
    private BodyMovementGroup bodyMovementGroup;
    private TimeSignature timeSignature;

    public BodyMovementGroupInstructionText(BodyMovementGroup bodyMovementGroup, TimeSignature timeSignature, Messages messages) {
        super(messages);
        this.bodyMovementGroup = bodyMovementGroup;
        this.timeSignature = timeSignature;
    }

    public List<BodyMovementInstructionText> getBodyMovementInstructionTexts() {
        return getBodyMovementGroup().getBodyMovements().stream().map(bodyMovement -> new BodyMovementInstructionText(bodyMovement, "", getMessages())).collect(Collectors.toList());
    }

    public boolean isCountingEightsNotes(){
        return getTimeLengthEachMovement()==0.125;
    }

    public boolean isCountingQuarterNotes(){
        return getTimeLengthEachMovement()==0.25;
    }

    protected double getTimeLengthEachMovement(){
        return getTimeLength()/(double)getBodyMovementCount();
    }

    protected double getTimeLength(){
        double noteLengthOneBeat = 1.0/(double)getTimeSignature().getNoteValueForOneBeat();
        return noteLengthOneBeat * (double)getCounts();
    }

    private int getCounts(){
        return getBodyMovementGroup().getCounts();
    }

    private int getBodyMovementCount(){
        return getBodyMovementGroup().getBodyMovements().size();
    }
}
