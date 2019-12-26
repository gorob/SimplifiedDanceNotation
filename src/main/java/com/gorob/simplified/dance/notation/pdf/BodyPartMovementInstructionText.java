package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.movedefinition.BodyPartMovement;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PRIVATE)
public class BodyPartMovementInstructionText extends AbstractInstructionText {
    private static final String SPECIAL_TEXT_CLOSE_RAISED_KEY = "DIRECTION_CLOSE_RAISED";
    private static final String BODY_PART_TYPE_STR_FOOT = "FOOT";
    private static final String BODY_PART_TYPE_STR_HAND = "HAND";
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

    private boolean isCourseLinear(){
        return getBodyPartMovement().getMovementAttributesXY().getCourse().equals(Course.LINEAR);
    }

    private boolean isWeightOnFloorEndNone(){
        return getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.NONE);
    }

    private boolean isWeightOnFloorEndWithTap(){
        return getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.TAP_HEEL) ||
                getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.TAP_TOE) ||
                getBodyPartMovement().getWeightOnFloorEnd().equals(WeightOnFloor.STOMP);
    }

    private boolean isBodyPartFoot(){
        return getBodyPartMovement().getBodyPart().isFoot();
    }

    private boolean isBodyPartHand(){
        return getBodyPartMovement().getBodyPart().isHand();
    }

    private String getBodyPartInstructionText(){
        return getMessage(getBodyPartShortNameKey());
    }

    private String getDistanceXYInstructionText(){
        return " " + getMessage(getDistanceMessageKey());
    }

    private String getCourseXYInstructionText(){
        return isCourseLinear() ? "" : " " + getMessage(getCourseMessageKey());
    }

    private String getDirectionXYInstructionText(){
        return " " + getMessage(getDirectionMessageKey());
    }

    private String getDirectionCloseXYInstructionText(){
        if (isBodyPartHand() || (isBodyPartFoot() && isRaisedAtTheEnd())){
            return " " + getMessage(getDirectionCloseAndWeightOnFloorEndRaisedMessageKey());
        }

        return getDirectionXYInstructionText();
    }

    private String getRotationXYInstructionText(){
        return " " + getMessage(getRotationMessageKey());
    }

    private String getWeightOnFloorInstructionText(){
        if (isWeightOnFloorEndNone()){
            return "";
        }

        String beginStr = isWeightOnFloorEndWithTap() ? getInstructionTextAnd() + " " : getInstructionTextClipBegin() + getInstructionTextAtTheEnd() + " ";
        String endStr = isWeightOnFloorEndWithTap() ? "" : getInstructionTextClipEnd();

        return " " + beginStr + getMessage(getWeightOnFloorEndMessageKey()) + endStr;
    }

    private String getMessage(String key){
        return getMessages().getMessage(key);
    }

    private String getDirectionCloseAndWeightOnFloorEndRaisedMessageKey(){
        return SPECIAL_TEXT_CLOSE_RAISED_KEY;
    }

    private String getBodyPartShortNameKey(){
        return BodyPart.class.getSimpleName().toUpperCase() + "_" + getBodyPartMovement().getBodyPart().name() + "_SHORT";
    }

    private String getBodyPartTypeKeyName(){
        String bodyPartClassName = BodyPart.class.getSimpleName().toUpperCase() + "_";
        if (isBodyPartFoot()){
            return bodyPartClassName + BODY_PART_TYPE_STR_FOOT;
        }
        if (isBodyPartHand()) {
            return bodyPartClassName + BODY_PART_TYPE_STR_HAND;
        }
        return "";
    }

    private String getDirectionMessageKey(){
        return Direction.class.getSimpleName().toUpperCase() + "_" + getBodyPartMovement().getMovementAttributesXY().getDirection().name();
    }

    private String getDistanceMessageKey(){
        return Distance.class.getSimpleName().toUpperCase() + "_" + getBodyPartMovement().getMovementAttributesXY().getDistance().name() + "_" + getBodyPartTypeKeyName();
    }

    private String getCourseMessageKey(){
        return Course.class.getSimpleName().toUpperCase() + "_" + getBodyPartMovement().getMovementAttributesXY().getCourse().name();
    }

    private String getRotationMessageKey(){
        return Rotation.class.getSimpleName().toUpperCase() + "_" + getBodyPartMovement().getMovementAttributesXY().getRotation().name();
    }

    private String getWeightOnFloorEndMessageKey(){
        return WeightOnFloor.class.getSimpleName().toUpperCase() + "_" + getBodyPartMovement().getWeightOnFloorEnd().name();
    }
}
