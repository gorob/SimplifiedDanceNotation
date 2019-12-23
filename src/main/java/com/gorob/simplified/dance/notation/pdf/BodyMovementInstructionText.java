package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyPartMovement;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PRIVATE)
public class BodyMovementInstructionText extends AbstractInstructionText {
    private BodyMovement bodyMovement;

    public BodyMovementInstructionText(BodyMovement bodyMovement, Messages messages){
        super(messages);
        this.bodyMovement = bodyMovement;
    }

    public List<BodyPartMovementInstructionText> getBodyPartMovementInstructionTexts() {
        return getBodyMovement().getBodyPartMovements().stream().map(bodyPartMovement -> new BodyPartMovementInstructionText(bodyPartMovement, getMessages())).collect(Collectors.toList());
    }
}
