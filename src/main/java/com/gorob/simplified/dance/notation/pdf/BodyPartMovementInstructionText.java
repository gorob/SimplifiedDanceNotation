package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyPartMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Course;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Direction;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.Rotation;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.WeightOnFloor;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter(AccessLevel.PRIVATE)
public class BodyPartMovementInstructionText extends AbstractInstructionText {
    private static final String SPECIAL_TEXT_CLOSE_RAISED_KEY = "DIRECTION_CLOSE_RAISED";
    private BodyPartMovement bodyPartMovement;

    public BodyPartMovementInstructionText(BodyPartMovement bodyPartMovement, Messages messages){
        super(messages);
        this.bodyPartMovement = bodyPartMovement;
    }

    public String getInstructionText(){
        return getBodyPartInstructionText() + getMoveInstructionText() + getWeightOnFloorInstructionText();
    }

    private String getMoveInstructionText(){
        return isRotationXY() ? getRotationXYMoveInstructionText() : getNonRotationXYMoveInstructionText();
    }

    private String getRotationXYMoveInstructionText(){
        return getRotationXYInstructionText() + getDirectionXYInstructionText();
    }

    private String getNonRotationXYMoveInstructionText(){
        if (isCloseMove()){
            return getDirectionCloseXYInstructionText();
        }

        return getDistanceXYInstructionText()
                + getCourseXYInstructionText()
                + getDirectionXYInstructionText();
    }

    private boolean isCloseMove(){
        return getBodyPartMovement().getMovementAttributesXY().getDirection().equals(Direction.CLOSE);
    }

    private boolean isRaisedAtTheEnd(){
        return getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.RAISED);
    }

    private boolean isRotationXY(){
        return !getBodyPartMovement().getMovementAttributesXY().getRotation().equals(Rotation.NONE);
    }

    private String getBodyPartInstructionText(){
        return getMessages().getMessage(getBodyPartMovement().getBodyPart().getShortNameKey());
    }

    private String getDistanceXYInstructionText(){
        return " " + getMessages().getMessage(getBodyPartMovement().getMovementAttributesXY().getDistance().getNameKey());
    }

    private String getCourseXYInstructionText(){
        Course course = getBodyPartMovement().getMovementAttributesXY().getCourse();
        return course.equals(Course.LINEAR) ? "" : " " + getMessages().getMessage(course.getNameKey());
    }

    private String getDirectionXYInstructionText(){
        return " " + getMessages().getMessage(getBodyPartMovement().getMovementAttributesXY().getDirection().getNameKey());
    }

    private String getDirectionCloseXYInstructionText(){
        if (isRaisedAtTheEnd()){
            return " " + getMessages().getMessage(SPECIAL_TEXT_CLOSE_RAISED_KEY);
        }

        return getDirectionXYInstructionText();
    }

    private String getRotationXYInstructionText(){
        return " " + getMessages().getMessage(getBodyPartMovement().getMovementAttributesXY().getRotation().getNameKey());
    }

    private String getWeightOnFloorInstructionText(){
        if (getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.NONE)){
            return "";
        }

        boolean isWithTap = getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.TAP_HEEL) ||
                getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.TAP_TOE) ||
                getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.STOMP);

        String beginStr = isWithTap ? getInstructionTextAnd() + " " : getInstructionTextClipBegin() + getInstructionTextAtTheEnd() + " ";
        String endStr = isWithTap ? "" : getInstructionTextClipEnd();

        return " " + beginStr + getMessages().getMessage(getBodyPartMovement().getWeightOnFloorEnd().getNameKey()) + endStr;
    }
}
