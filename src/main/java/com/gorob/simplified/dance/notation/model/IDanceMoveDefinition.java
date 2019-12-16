package com.gorob.simplified.dance.notation.model;

import java.util.List;

public interface IDanceMoveDefinition {
    String getId();
    String getDefaultName();
    List<IDanceMoveVariantDefinition> getDanceMoveVariantDefinitions();
}
