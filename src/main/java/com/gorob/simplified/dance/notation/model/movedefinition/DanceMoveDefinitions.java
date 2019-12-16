package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.IDanceMoveDefinition;
import com.gorob.simplified.dance.notation.model.IDanceMoveVariantDefinition;
import com.gorob.simplified.dance.notation.parser.movedefinitions.DanceMoveDefinitionsParser;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
public class DanceMoveDefinitions {
    private List<IDanceMoveDefinition> danceMoveDefinitions;

    public DanceMoveDefinitions(File danceMoveDefinitionsLocation){
        this.danceMoveDefinitions = new DanceMoveDefinitionsParser().parseDefinitionFiles(danceMoveDefinitionsLocation);
    }

    public List<String> getDanceMoveVariantDefinitionIds(){
        return getAllDanceMoveVariantDefinitions().stream().map(IDanceMoveVariantDefinition::getId).collect(Collectors.toList());
    }

    public IDanceMoveVariantDefinition getDanceMoveVariantDefinitionById(String id){
        List<IDanceMoveVariantDefinition> danceMoveVariantDefinitions = getAllDanceMoveVariantDefinitions();
        danceMoveVariantDefinitions = danceMoveVariantDefinitions.stream().filter(danceMoveVariantDefinition -> danceMoveVariantDefinition.getId().equals(id)).collect(Collectors.toList());
        return danceMoveVariantDefinitions.isEmpty() ? null : danceMoveVariantDefinitions.get(0);
    }

    private List<IDanceMoveVariantDefinition> getAllDanceMoveVariantDefinitions(){
        List<IDanceMoveVariantDefinition> danceMoveVariantDefinitions = new ArrayList<>();
        getDanceMoveDefinitions().forEach(danceMoveDefinition -> danceMoveVariantDefinitions.addAll(danceMoveDefinition.getDanceMoveVariantDefinitions()));
        return danceMoveVariantDefinitions;
    }
}
