package com.gorob.simplified.dance.notation.model.dance;

import com.gorob.simplified.dance.notation.model.movedefinition.DanceMoveVariantDefinition;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class Dance {
    private String title;
    private int wall;
    private int count;
    private int startCount;
    private TimeSignature timeSignature;
    private List<AbstractMediaMetaInfo> mediaMetaInfos;
    private List<DanceMoveVariantDefinition> danceMoves;

    public Dance(String title, int wall, int count, int startCount, TimeSignature timeSignature){
        this.title = title;
        this.wall = wall;
        this.count = count;
        this.startCount = startCount;
        this.timeSignature = timeSignature;
        this.mediaMetaInfos = new ArrayList<>();
        this.danceMoves = new ArrayList<>();
    }

    public void addDanceMove(DanceMoveVariantDefinition danceMoveVariantDefinition){
        this.getDanceMoves().add(danceMoveVariantDefinition);
    }

    public void addChoreographyMetaInfo(ChoreographyMetaInfo choreographyMetaInfo){
        this.getMediaMetaInfos().add(choreographyMetaInfo);
    }

    public void addMusicMetaInfo(MusicMetaInfo musicMetaInfo){
        getMediaMetaInfos().add(musicMetaInfo);
    }

    public ChoreographyMetaInfo getChoreographyMetaInfo(){
        return (ChoreographyMetaInfo)getMediaMetaInfoForType(ChoreographyMetaInfo.class);
    }

    public MusicMetaInfo getMusicMetaInfo(){
        return (MusicMetaInfo)getMediaMetaInfoForType(MusicMetaInfo.class);
    }

    private AbstractMediaMetaInfo getMediaMetaInfoForType(Class clazz){
        List<AbstractMediaMetaInfo> mediaMetaInfos = getMediaMetaInfos().stream().filter(mediaMetaInfo -> mediaMetaInfo.getClass().equals(clazz)).collect(Collectors.toList());
        return mediaMetaInfos.isEmpty() ? null : mediaMetaInfos.get(0);
    }
}
