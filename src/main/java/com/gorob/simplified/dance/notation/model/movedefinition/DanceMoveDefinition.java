package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.IDanceMoveDefinition;
import com.gorob.simplified.dance.notation.model.IDanceMoveVariantDefintion;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DanceMoveDefinition implements IDanceMoveDefinition {
    private String id;
    private String defaultName;
    private List<IDanceMoveVariantDefintion> danceMoveVariantDefinitions;

    public DanceMoveDefinition(String id, String defaultName){
        this.id = id;
        this.defaultName = defaultName;
        this.danceMoveVariantDefinitions = new ArrayList<>();
    }

    public void addDanceMoveVariantDefinition(IDanceMoveVariantDefintion danceMoveVariantDefintion){
        this.getDanceMoveVariantDefinitions().add(danceMoveVariantDefintion);
    }
}
