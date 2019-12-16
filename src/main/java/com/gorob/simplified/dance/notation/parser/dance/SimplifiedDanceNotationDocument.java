package com.gorob.simplified.dance.notation.parser.dance;

import com.gorob.simplified.dance.notation.parser.AbstractDocumentWrapper;
import lombok.AccessLevel;
import lombok.Getter;

import java.io.File;

@Getter(AccessLevel.PRIVATE)
public class SimplifiedDanceNotationDocument extends AbstractDocumentWrapper {
    protected static final String EXTENSION_DANCE_MOVE_DEFINITION_DOCUMENT = "sdn";

    public static final String NODE_NAME_ROOT = "SimplifiedDanceNotation";

    public SimplifiedDanceNotationDocument(File sdnFile) {
        super(sdnFile);
    }

    @Override
    protected String getMyExtension() {
        return EXTENSION_DANCE_MOVE_DEFINITION_DOCUMENT;
    }

    @Override
    protected String getMyRootNodeName() {
        return NODE_NAME_ROOT;
    }
}
