package com.gorob.simplified.dance.notation.model.movedefinition;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class BodyMovementGroup {
    private int counts;
    private List<BodyMovement> bodyMovements;

    public BodyMovementGroup(int counts){
        this.counts = counts;
        this.bodyMovements = new ArrayList<>();
    }

    public void addBodyMovement(BodyMovement bodyMovement){
        this.getBodyMovements().add(bodyMovement);
    }
}
