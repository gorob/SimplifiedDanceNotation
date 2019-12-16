package com.gorob.simplified.dance.notation.model.dance;

import com.gorob.simplified.dance.notation.model.ModelCreator;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public abstract class AbstractMediaMetaInfo {
    private String title;
    private String creatorName;
    private int year;
    private List<MediaRef> mediaReferences;

    public AbstractMediaMetaInfo(String title, String creatorName, int year, MediaRef... initialMediaRef){
        this.title = title;
        this.creatorName = creatorName;
        this.year = year;
        this.mediaReferences = Arrays.asList(initialMediaRef);
    }

    public void addMediaReference(MediaService mediaService, MediaType mediaType, String ref){
        getMediaReferences().add(ModelCreator.createMediaReference(mediaService, mediaType, ref));
    }
}
