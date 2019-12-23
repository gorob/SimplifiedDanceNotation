package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.parser.movedefinitions.DanceMoveDefinitionsParser;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
@EqualsAndHashCode
public class DanceMoveDefinitions {
    private List<DanceMoveDefinition> danceMoveDefinitions;

    public DanceMoveDefinitions(File danceMoveDefinitionsLocation){
        this.danceMoveDefinitions = new DanceMoveDefinitionsParser().parseDefinitionFiles(danceMoveDefinitionsLocation);
    }

    public List<String> getDanceMoveVariantDefinitionIds(){
        return getAllDanceMoveVariantDefinitions().stream().map(DanceMoveVariantDefinition::getId).collect(Collectors.toList());
    }

    public DanceMoveVariantDefinition getDanceMoveVariantDefinitionById(String id){
        List<DanceMoveVariantDefinition> danceMoveVariantDefinitions = getAllDanceMoveVariantDefinitions();
        danceMoveVariantDefinitions = danceMoveVariantDefinitions.stream().filter(danceMoveVariantDefinition -> danceMoveVariantDefinition.getId().equals(id)).collect(Collectors.toList());
        return danceMoveVariantDefinitions.isEmpty() ? null : danceMoveVariantDefinitions.get(0);
    }

    private List<DanceMoveVariantDefinition> getAllDanceMoveVariantDefinitions(){
        List<DanceMoveVariantDefinition> danceMoveVariantDefinitions = new ArrayList<>();
        getDanceMoveDefinitions().forEach(danceMoveDefinition -> danceMoveVariantDefinitions.addAll(danceMoveDefinition.getDanceMoveVariantDefinitions()));
        return danceMoveVariantDefinitions;
    }
}
