package com.gorob.simplified.dance.notation.parser.movedefinitions;

import com.gorob.simplified.dance.notation.model.IDanceMoveDefinition;
import com.gorob.simplified.dance.notation.parser.movedefinitions.DanceMoveDefinitionsDocument;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DanceMoveDefinitionsParser {
    public List<IDanceMoveDefinition> parseDefinitionFiles(File folder) {
        List<IDanceMoveDefinition> danceMoveDefinitions = new ArrayList<>();
        Arrays.stream(folder.listFiles()).filter(file -> file.isFile()).forEach(file -> danceMoveDefinitions.addAll(parseSingleDefinitionFile(file)));
        return danceMoveDefinitions;
    }

    public List<IDanceMoveDefinition> parseSingleDefinitionFile(File dmdFile){
        DanceMoveDefinitionsDocument dmdDocument = new DanceMoveDefinitionsDocument(dmdFile);

        if (!dmdDocument.isCorrectDocumentType()){
            return new ArrayList<>();
        }

        return dmdDocument.getDanceMoveDefinitions();
    }
}
