package com.gorob.simplified.dance.notation.model;

import java.util.List;

public interface IBodyMovement {
    int getCountNr();
    List<IBodyPartMovement> getBodyPartMovements();
}
