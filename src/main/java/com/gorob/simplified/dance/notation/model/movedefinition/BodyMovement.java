package com.gorob.simplified.dance.notation.model.movedefinition;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class BodyMovement {
    private List<BodyPartMovement> bodyPartMovements;

    public BodyMovement(){
        this.bodyPartMovements = new ArrayList<>();
    }

    public void addBodyPartMovement(BodyPartMovement bodyPartMovement){
        this.getBodyPartMovements().add(bodyPartMovement);
    }
}
