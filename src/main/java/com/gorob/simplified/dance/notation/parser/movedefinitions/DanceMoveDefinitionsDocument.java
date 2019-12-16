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

    protected static final String NODE_NAME_BODY_MOVEMENT = "Movement";
    protected static final String ATTRIBUTE_NAME_BODY_MOVEMENT_COUNTNR = "countNr";

    protected static final String NODE_NAME_BODY_PART_MOVEMENT = "SubMovement";
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

    public List<IDanceMoveDefinition> getDanceMoveDefinitions(){
        return getNodesByName(getRootNode(), NODE_NAME_DANCE_MOVE_DEFINITION).stream().map(danceMoveDefinitionNode -> mapDanceMoveDefinition(danceMoveDefinitionNode)).collect(Collectors.toList());
    }

    private IDanceMoveDefinition mapDanceMoveDefinition(Node danceMoveDefinitionNode) {
        String id = getAttributeValue(danceMoveDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_DEFINITION_ID);
        String defaultName = getAttributeValue(danceMoveDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_DEFINITION_DEFAULT_NAME);
        DanceMoveDefinition danceMoveDefinition = ModelCreator.createDanceMoveDefinition(id, defaultName);

        List<IDanceMoveVariantDefinition> danceMoveVariantDefinitions = getNodesByName(danceMoveDefinitionNode, NODE_NAME_DANCE_MOVE_VARIANT_DEFINITION).stream().map(danceMoveVariantDefintionNode -> mapDanceMoveVariantDefinition(danceMoveVariantDefintionNode)).collect(Collectors.toList());

        danceMoveVariantDefinitions.forEach(danceMoveVariantDefinition -> danceMoveDefinition.addDanceMoveVariantDefinition(danceMoveVariantDefinition));

        return danceMoveDefinition;
    }

    private IDanceMoveVariantDefinition mapDanceMoveVariantDefinition(Node danceMoveVariantDefinitionNode) {
        String id = getAttributeValue(danceMoveVariantDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_VARIANT_DEFINITION_ID);
        String defaultName = getAttributeValue(danceMoveVariantDefinitionNode, ATTRIBUTE_NAME_DANCE_MOVE_VARIANT_DEFINITION_DEFAULT_NAME);
        DanceMoveVariantDefinition danceMoveVariantDefinition = ModelCreator.createDanceMoveVariantDefinition(id, defaultName);

        List<IBodyMovement> bodyMovements = getNodesByName(danceMoveVariantDefinitionNode, NODE_NAME_BODY_MOVEMENT).stream().map(bodyMovementNode -> mapBodyMovement(bodyMovementNode)).collect(Collectors.toList());

        bodyMovements.forEach(bodyMovementNode -> danceMoveVariantDefinition.addBodyMovement(bodyMovementNode));

        return danceMoveVariantDefinition;
    }

    private IBodyMovement mapBodyMovement(Node bodyMovementNode) {
        int countNr = Integer.parseInt(getAttributeValue(bodyMovementNode, ATTRIBUTE_NAME_BODY_MOVEMENT_COUNTNR));
        BodyMovement bodyMovement = ModelCreator.createBodyMovement(countNr);

        List<IBodyPartMovement> bodyPartMovements = getNodesByName(bodyMovementNode, NODE_NAME_BODY_PART_MOVEMENT).stream().map(bodyPartMovementNode -> mapBodyPartMovement(bodyPartMovementNode)).collect(Collectors.toList());

        bodyPartMovements.forEach(bodyPartMovement -> bodyMovement.addBodyPartMovement(bodyPartMovement));

        return bodyMovement;
    }

    private IBodyPartMovement mapBodyPartMovement(Node bodyPartMovementNode) {
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
