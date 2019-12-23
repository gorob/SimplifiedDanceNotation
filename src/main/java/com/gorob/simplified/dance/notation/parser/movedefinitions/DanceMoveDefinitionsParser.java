package com.gorob.simplified.dance.notation.parser.movedefinitions;

import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveDefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DanceMoveDefinitionsParser {
    public List<DanceMoveDefinition> parseDefinitionFiles(File folder) {
        List<DanceMoveDefinition> danceMoveDefinitions = new ArrayList<>();
        Arrays.stream(folder.listFiles()).filter(file -> file.isFile()).forEach(file -> danceMoveDefinitions.addAll(parseSingleDefinitionFile(file)));
        return danceMoveDefinitions;
    }

    public List<DanceMoveDefinition> parseSingleDefinitionFile(File dmdFile){
        DanceMoveDefinitionsDocument dmdDocument = new DanceMoveDefinitionsDocument(dmdFile);

        if (!dmdDocument.isCorrectDocumentType()){
            return new ArrayList<>();
        }

        return dmdDocument.getDanceMoveDefinitions();
    }
}
