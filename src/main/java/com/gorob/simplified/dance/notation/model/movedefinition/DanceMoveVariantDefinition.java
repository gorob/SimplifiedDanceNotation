package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.IBodyMovement;
import com.gorob.simplified.dance.notation.model.IDanceMoveVariantDefintion;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DanceMoveVariantDefinition implements IDanceMoveVariantDefintion {
    private String id;
    private String defaultName;

    private List<IBodyMovement> bodyMovements;

    public DanceMoveVariantDefinition(String id, String defaultName){
        this.id = id;
        this.defaultName = defaultName;
        this.bodyMovements = new ArrayList<>();
    }

    public void addBodyMovement(IBodyMovement bodyMovement){
        getBodyMovements().add(bodyMovement);
    }

    public List<IBodyMovement> getBodyMovementsForCount(int countNr){
        return getBodyMovements().stream().filter(bodyMovement -> bodyMovement.getCountNr()==countNr).collect(Collectors.toList());
    }
}
