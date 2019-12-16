package com.gorob.simplified.dance.notation.model.dance;

import com.gorob.simplified.dance.notation.model.IDanceMoveVariantDefinition;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Dance {
    private int walls;
    private int count;
    private int startCount;
    private String timeSignature;
    private List<AbstractMediaMetaInfo> mediaMetaInfos;
    private List<IDanceMoveVariantDefinition> danceMoves;

    public Dance(int walls, int count, int startCount, String timeSignature){
        this.walls = walls;
        this.count = count;
        this.startCount = startCount;
        this.timeSignature = timeSignature;
        this.mediaMetaInfos = new ArrayList<>();
        this.danceMoves = new ArrayList<>();
    }

    public void addDanceMove(IDanceMoveVariantDefinition danceMoveVariantDefinition){
        this.getDanceMoves().add(danceMoveVariantDefinition);
    }

    public void addChoreographyMetaInfo(ChoreographyMetaInfo choreographyMetaInfo){
        this.getMediaMetaInfos().add(choreographyMetaInfo);
    }

    public void addMusicMetaInfo(MusicMetaInfo musicMetaInfo){
        getMediaMetaInfos().add(musicMetaInfo);
    }
}
