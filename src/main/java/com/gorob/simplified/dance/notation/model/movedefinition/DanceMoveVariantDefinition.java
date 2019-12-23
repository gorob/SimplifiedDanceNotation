package com.gorob.simplified.dance.notation.model.movedefinition;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class DanceMoveVariantDefinition {
    private String id;
    private String defaultName;

    private List<BodyMovementGroup> bodyMovementGroups;

    public DanceMoveVariantDefinition(String id, String defaultName){
        this.id = id;
        this.defaultName = defaultName;
        this.bodyMovementGroups = new ArrayList<>();
    }

    public void addBodyMovementGroup (BodyMovementGroup bodyMovementGroup){
        getBodyMovementGroups().add(bodyMovementGroup);
    }
}
