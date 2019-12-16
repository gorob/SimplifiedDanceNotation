package com.gorob.simplified.dance.notation.model.movedefinition;

import com.gorob.simplified.dance.notation.model.IBodyMovement;
import com.gorob.simplified.dance.notation.model.IBodyPartMovement;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class BodyMovement implements IBodyMovement {
    private int countNr;
    private List<IBodyPartMovement> bodyPartMovements;

    public BodyMovement(int countNr){
        this.countNr = countNr;
        this.bodyPartMovements = new ArrayList<>();
    }

    public void addBodyPartMovement(IBodyPartMovement bodyPartMovement){
        this.getBodyPartMovements().add(bodyPartMovement);
    }
}
