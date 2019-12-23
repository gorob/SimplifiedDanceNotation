package com.gorob.simplified.dance.notation.parser.movedefinitions;

import com.gorob.simplified.dance.notation.model.*;
import com.gorob.simplified.dance.notation.model.movedefinition.*;
import com.gorob.simplified.dance.notation.model.movedefinition.enums.*;
import com.gorob.simplified.dance.notation.parser.AbstractDocumentWrapper;
import lombok.AccessLevel;
import lombok.Getter;
import org.w3c.dom.Node;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PRIVATE)
public class DanceMoveDefinitionsDocument extends AbstractDocumentWrapper {
    protected static final String EXTENSION_DANCE_MOVE_DEFINITION_DOCUMENT = "dmd";

    protected static final String NODE_NAME_ROOT = "DanceMoveDefinitions";

    protected static final String NODE_NAME_DANCE_MOVE_DEFINITION = "DanceMoveDefinition";
    protected static final String ATTRIBUTE_NAME_DANCE_MOVE_DEFINITION_ID = "id";
    protected static final String ATTRIBUTE_NAME_DANCE_MOVE_DEFINITION_DEFAULT_NAME = "defaultName";

    protected static final String NODE_NAME_DANCE_MOVE_VARIANT_DEFINITION = "DanceMoveVariantDefinition";
    protected static final String ATTRIBUTE_NAME_DANCE_MOVE_VARIANT_DEFINITION_ID = "id";
    protected static final String ATTRIBUTE_NAME_DANCE_MOVE_VARIANT_DEFINITION_DEFAULT_NAME = "defaultName";

    protected static final String NODE_NAME_BODY_MOVEMENT_GROUP = "BodyMovementGroup";
    protected static final String ATTRIBUTE_NAME_BODY_MOVEMENT_GROUP_COUNTS = "counts";

    protected static final String NODE_NAME_BODY_MOVEMENT = "BodyMovement";

    protected static final String NODE_NAME_BODY_PART_MOVEMENT = "BodyPartMovement";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_BODYPART = "bodyPart";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DIRECTION_XY = "directionXY";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_COURSE_XY = "courseXY";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DISTANCE_XY = "distanceXY";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_ROTATION_XY = "rotationXY";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DIRECTION_Z = "directionZ";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_COURSE_Z = "courseZ";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DISTANCE_Z = "distanceZ";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_ROTATION_Z = "rotationZ";
    protected static final String ATTRIBUTE_NAME_BODY_PART_MOVEMENT_WEIGHT_ON_FLOOR = "weightOnFloorEnd";

    public DanceMoveDefinitionsDocument(File dmdFile) {
        super(dmdFile);
    }

    @Override
    protected String getMyExtension() {
        return EXTENSION_DANCE_MOVE_DEFINITION_DOCUMENT;
    }

    @Override
    protected String getMyRootNodeName() {
        return NODE_NAME_ROOT;
    }

    public List<DanceMoveDefinition> getDanceMoveDefinitions(){
        return getNodesByName(getRootNode(), NODE_NAME_DANCE_MOVE_DEFINITION).stream().map(danceMoveDefinitionNode -> mapDanceMoveDefinition(danceMoveDefinitionNode)).collect(Collectors.toList());
    }

    private DanceMoveDefinition mapDanceMoveDefinition(Node danceMoveDefinitionNode) {
        String id = getAttributeValue(danceMoveDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_DEFINITION_ID);
        String defaultName = getAttributeValue(danceMoveDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_DEFINITION_DEFAULT_NAME);
        DanceMoveDefinition danceMoveDefinition = ModelCreator.createDanceMoveDefinition(id, defaultName);

        List<DanceMoveVariantDefinition> danceMoveVariantDefinitions = getNodesByName(danceMoveDefinitionNode, NODE_NAME_DANCE_MOVE_VARIANT_DEFINITION).stream().map(danceMoveVariantDefintionNode -> mapDanceMoveVariantDefinition(danceMoveVariantDefintionNode)).collect(Collectors.toList());

        danceMoveVariantDefinitions.forEach(danceMoveVariantDefinition -> danceMoveDefinition.addDanceMoveVariantDefinition(danceMoveVariantDefinition));

        return danceMoveDefinition;
    }

    private DanceMoveVariantDefinition mapDanceMoveVariantDefinition(Node danceMoveVariantDefinitionNode) {
        String id = getAttributeValue(danceMoveVariantDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_VARIANT_DEFINITION_ID);
        String defaultName = getAttributeValue(danceMoveVariantDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_VARIANT_DEFINITION_DEFAULT_NAME);
        DanceMoveVariantDefinition danceMoveVariantDefinition = ModelCreator.createDanceMoveVariantDefinition(id, defaultName);

        List<BodyMovementGroup> bodyMovementGroups = getNodesByName(danceMoveVariantDefinitionNode, NODE_NAME_BODY_MOVEMENT_GROUP).stream().map(bodyMovementGroupNode -> mapBodyMovementGroup(bodyMovementGroupNode)).collect(Collectors.toList());

        bodyMovementGroups.forEach(bodyMovementGroupNode -> danceMoveVariantDefinition.addBodyMovementGroup(bodyMovementGroupNode));

        return danceMoveVariantDefinition;
    }

    private BodyMovementGroup mapBodyMovementGroup(Node bodyMovementGroupNode){
        int counts = Integer.parseInt(getAttributeValue(bodyMovementGroupNode, ATTRIBUTE_NAME_BODY_MOVEMENT_GROUP_COUNTS));

        BodyMovementGroup bodyMovementGroup = ModelCreator.createBodyMovementGroup(counts);

        List<BodyMovement> bodyMovements = getNodesByName(bodyMovementGroupNode, NODE_NAME_BODY_MOVEMENT).stream().map(bodyMovementNode -> mapBodyMovement(bodyMovementNode)).collect(Collectors.toList());

        bodyMovements.forEach(bodyMovement -> bodyMovementGroup.addBodyMovement(bodyMovement));

        return bodyMovementGroup;
    }

    private BodyMovement mapBodyMovement(Node bodyMovementNode) {
        BodyMovement bodyMovement = ModelCreator.createBodyMovement();

        List<BodyPartMovement> bodyPartMovements = getNodesByName(bodyMovementNode, NODE_NAME_BODY_PART_MOVEMENT).stream().map(bodyPartMovementNode -> mapBodyPartMovement(bodyPartMovementNode)).collect(Collectors.toList());

        bodyPartMovements.forEach(bodyPartMovement -> bodyMovement.addBodyPartMovement(bodyPartMovement));

        return bodyMovement;
    }

    private BodyPartMovement mapBodyPartMovement(Node bodyPartMovementNode) {
        BodyPart bodyPart = BodyPart.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_BODYPART).toUpperCase());
        Direction directionXY = Direction.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DIRECTION_XY).toUpperCase());
        Course courseXY = Course.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_COURSE_XY).toUpperCase());
        Distance distanceXY = Distance.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DISTANCE_XY).toUpperCase());
        Rotation rotationXY = Rotation.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_ROTATION_XY).toUpperCase());
        Direction directionZ = Direction.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DIRECTION_Z).toUpperCase());
        Course courseZ = Course.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_COURSE_Z).toUpperCase());
        Distance distanceZ = Distance.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_DISTANCE_Z).toUpperCase());
        Rotation rotationZ = Rotation.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_ROTATION_Z).toUpperCase());
        WeightOnFloor weightOnFloorEnd = WeightOnFloor.valueOf(getAttributeValue(bodyPartMovementNode, ATTRIBUTE_NAME_BODY_PART_MOVEMENT_WEIGHT_ON_FLOOR).toUpperCase());
        MovementAttributes movementAttributesXY = ModelCreator.createMovementAttributes(directionXY, courseXY, distanceXY, rotationXY);
        MovementAttributes movementAttributesZ = ModelCreator.createMovementAttributes(directionZ, courseZ, distanceZ, rotationZ);
        return ModelCreator.createBodyPartMovement(bodyPart, movementAttributesXY, movementAttributesZ, weightOnFloorEnd);
    }
}
