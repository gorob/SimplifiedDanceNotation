package com.gorob.simplified.dance.notation.model.movedefinition;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class DanceMoveDefinition {
    private String id;
    private String defaultName;
    private List<DanceMoveVariantDefinition> danceMoveVariantDefinitions;

    public DanceMoveDefinition(String id, String defaultName){
        this.id = id;
        this.defaultName = defaultName;
        this.danceMoveVariantDefinitions = new ArrayList<>();
    }

    public void addDanceMoveVariantDefinition(DanceMoveVariantDefinition danceMoveVariantDefintion){
        this.getDanceMoveVariantDefinitions().add(danceMoveVariantDefintion);
    }
}
