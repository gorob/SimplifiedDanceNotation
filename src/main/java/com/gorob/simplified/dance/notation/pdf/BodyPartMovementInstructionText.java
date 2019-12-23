package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyPartMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Course;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Rotation;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.WeightOnFloor;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PRIVATE)
public class BodyPartMovementInstructionText {
    private static final String INSTRUCTION_TEXT_PART_KEY_AND = "INSTRUCTION_TEXT_PART_AND";
    private static final String INSTRUCTION_TEXT_PART_KEY_CLIP_BEGIN = "INSTRUCTION_TEXT_PART_CLIP_BEGIN";
    private static final String INSTRUCTION_TEXT_PART_KEY_CLIP_END = "INSTRUCTION_TEXT_PART_CLIP_END";
    private static final String INSTRUCTION_TEXT_PART_KEY_AT_THE_END = "INSTRUCTION_TEXT_PART_AT_THE_END";

    private BodyPartMovement bodyPartMovement;

    public BodyPartMovementInstructionText(BodyPartMovement bodyPartMovement){
        this.bodyPartMovement = bodyPartMovement;
    }

    public String getInstructionText(Messages messages){
        return getBodyPartInstructionText(messages) + getMoveInstructionText(messages) + getWeightOnFloorInstructionText(messages);
    }

    private String getMoveInstructionText(Messages messages){
        return isRotationXY() ? getRotationXYMoveInstructionText(messages) : getNonRotationXYMoveInstructionText(messages);
    }

    private String getRotationXYMoveInstructionText(Messages messages){
        return getRotationXYInstructionText(messages) + getDirectionXYInstructionText(messages);
    }

    private String getNonRotationXYMoveInstructionText(Messages messages){
        return getDistanceXYInstructionText(messages)
                + getCourseXYInstructionText(messages)
                + getDirectionXYInstructionText(messages);
    }

    private boolean isRotationXY(){
        return !getBodyPartMovement().getMovementAttributesXY().getRotation().equals(Rotation.NONE);
    }

    private String getBodyPartInstructionText(Messages messages){
        return messages.getMessage(getBodyPartMovement().getBodyPart().getShortNameKey());
    }

    private String getDistanceXYInstructionText(Messages messages){
        return " " + messages.getMessage(getBodyPartMovement().getMovementAttributesXY().getDistance().getNameKey());
    }

    private String getCourseXYInstructionText(Messages messages){
        Course course = getBodyPartMovement().getMovementAttributesXY().getCourse();
        return course.equals(Course.LINEAR) ? "" : " " + messages.getMessage(course.getNameKey());
    }

    private String getDirectionXYInstructionText(Messages messages){
        return " " + messages.getMessage(getBodyPartMovement().getMovementAttributesXY().getDirection().getNameKey());
    }

    private String getRotationXYInstructionText(Messages messages){
        return " " + messages.getMessage(getBodyPartMovement().getMovementAttributesXY().getRotation().getNameKey());
    }

    private String getWeightOnFloorInstructionText(Messages messages){
        boolean isWithTap = getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.TAP_HEEL) ||
                getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.TAP_TOE) ||
                getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.STOMP);

        String beginStr = isWithTap ? getInstructionTextAnd(messages) + " " : getInstructionTextClipBegin(messages) + getInstructionTextAtTheEnd(messages) + " ";
        String endStr = isWithTap ? "" : getInstructionTextClipEnd(messages);

        return " " + beginStr + messages.getMessage(getBodyPartMovement().getWeightOnFloorEnd().getNameKey()) + endStr;
    }

    private String getInstructionTextAnd(Messages messages){
        return messages.getMessage(INSTRUCTION_TEXT_PART_KEY_AND);
    }

    private String getInstructionTextClipBegin(Messages messages){
        return messages.getMessage(INSTRUCTION_TEXT_PART_KEY_CLIP_BEGIN);
    }

    private String getInstructionTextClipEnd(Messages messages){
        return messages.getMessage(INSTRUCTION_TEXT_PART_KEY_CLIP_END);
    }

    private String getInstructionTextAtTheEnd(Messages messages){
        return messages.getMessage(INSTRUCTION_TEXT_PART_KEY_AT_THE_END);
    }
}
