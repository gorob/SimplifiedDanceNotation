package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovementGroup;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PRIVATE)
public class BodyMovementGroupInstructionText extends AbstractInstructionText {
    private BodyMovementGroup bodyMovementGroup;

    public BodyMovementGroupInstructionText(BodyMovementGroup bodyMovementGroup, Messages messages) {
        super(messages);
        this.bodyMovementGroup = bodyMovementGroup;
    }

    public List<BodyMovementInstructionText> getBodyMovementInstructionTexts() {
        return getBodyMovementGroup().getBodyMovements().stream().map(bodyMovement -> new BodyMovementInstructionText(bodyMovement, getMessages())).collect(Collectors.toList());
    }
}
