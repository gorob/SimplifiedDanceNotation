package com.gorob.simplified.dance.notation.model;

import java.util.List;

public interface IDanceMoveVariantDefintion {
    String getId();
    String getDefaultName();

    void addBodyMovement(IBodyMovement bodyMovement);
    List<IBodyMovement> getBodyMovementsForCount(int countNr);
}
