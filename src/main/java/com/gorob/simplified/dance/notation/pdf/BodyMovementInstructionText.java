package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyPartMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.BodyPart;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.BodyPartGroup;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PRIVATE)
public class BodyMovementInstructionText extends AbstractInstructionText {
    private BodyMovement bodyMovement;

    @Getter(AccessLevel.PUBLIC)
    private String countSyllable;

    public BodyMovementInstructionText(BodyMovement bodyMovement, String countSyllable, Messages messages){
        super(messages);
        this.bodyMovement = bodyMovement;
        this.countSyllable = countSyllable;
    }

    public List<BodyPartMovementInstructionText> getBodyPartMovementInstructionTexts() {
        return getBodyMovement().getBodyPartMovements().stream().map(bodyPartMovement -> new BodyPartMovementInstructionText(bodyPartMovement, getMessages())).sorted(Comparator.comparing(BodyPartMovementInstructionText::getInstructionText).reversed()).collect(Collectors.toList());
    }

    public String getText(){
        StringBuffer instructionText = new StringBuffer();

        List<BodyPartMovementInstructionText> allBodyPartMovementInstructionTexts = getBodyPartMovementInstructionTexts();

        for (BodyPartGroup bodyPartGroup : BodyPartGroup.values()){
            String instructionTextForGroup = getInstructionTextForGroup(allBodyPartMovementInstructionTexts, bodyPartGroup);
            instructionText.append(instructionTextForGroup);
        }

        return instructionText.delete(instructionText.length()-2, instructionText.length()).toString();
    }

    private String getInstructionTextForGroup(List<BodyPartMovementInstructionText> allBodyPartMovementInstructionTexts, BodyPartGroup bodyPartGroup){
        StringBuffer bodyPartMovementInstructionTextForGroup = new StringBuffer();

        for (BodyPartMovementInstructionText bodyPartMovementInstructionText : getBodyPartMovementInstructionTextsForGroup(allBodyPartMovementInstructionTexts, bodyPartGroup)){
            String nonBodyPartInstructionText = bodyPartMovementInstructionText.getNonBodyPartInstructionText() + "; ";
            if (bodyPartMovementInstructionTextForGroup.lastIndexOf(nonBodyPartInstructionText)>-1){
                bodyPartMovementInstructionTextForGroup.insert(0, bodyPartMovementInstructionText.getBodyPartInstructionText() + " " + bodyPartMovementInstructionText.getInstructionTextAnd() + " ");
            } else {
                bodyPartMovementInstructionTextForGroup.append(bodyPartMovementInstructionText.getInstructionText() + "; ");
            }
        }

        return bodyPartMovementInstructionTextForGroup.toString();
    }

    private List<BodyPartMovementInstructionText> getBodyPartMovementInstructionTextsForGroup(List<BodyPartMovementInstructionText> bodyPartMovementInstructionTexts, BodyPartGroup bodyPartGroup){
        return bodyPartMovementInstructionTexts.stream().filter(bodyPartMovementInstructionText -> bodyPartMovementInstructionText.belongsToBodyPartGroup(bodyPartGroup)).collect(Collectors.toList());
    }
}

