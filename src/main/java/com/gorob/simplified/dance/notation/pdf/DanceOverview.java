package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import com.gorob.simplified.dance.notation.model.dance.Dance;
import com.gorob.simplified.dance.notation.model.dance.MediaRef;
import com.gorob.simplified.dance.notation.model.dance.TimeSignature;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
@EqualsAndHashCode
public class DanceOverview extends AbstractInstructionText {
    private static final String LABEL_CHOREOGRAPHY = "Choreographie: ";
    private static final String LABEL_MUSIC = "Musik: ";

    private Dance dance;

    public DanceOverview(Dance dance, Messages messages){
        super(messages);
        this.dance = dance;
    }

    public String getTitle() {
        return getDance().getTitle() + " (" + getDance().getWall() + " Wall, " + getDance().getCount() + " Count)";
    }

    public String getChoreographyTitle(){
        return LABEL_CHOREOGRAPHY + getDance().getChoreographyMetaInfo().getCreatorName() + " (" + getDance().getChoreographyMetaInfo().getYear() + ")";
    }

    public List<String> getChoreographyMediaRefs(){
        return getDance().getChoreographyMetaInfo().getMediaReferences().stream().map(mediaRef -> getMediaRefStr(mediaRef)).collect(Collectors.toList());
    }

    public String getMusicTitle(){
        return LABEL_MUSIC + getDance().getMusicMetaInfo().getTitle() + " von " + getDance().getMusicMetaInfo().getCreatorName() + " (" + getDance().getMusicMetaInfo().getYear() + ")";
    }

    public List<String> getMusicMediaRefs() {
        return getDance().getMusicMetaInfo().getMediaReferences().stream().map(mediaRef -> getMediaRefStr(mediaRef)).collect(Collectors.toList());
    }

    private String getMediaRefStr(MediaRef mediaRef){
        return "   => " + mediaRef.getService().getName() + ": " + mediaRef.getRef();
    }

    public List<DanceMoveInstructionText> getDanceMoveInstructionTexts(){
        return getDance().getDanceMoves().stream().map(danceMoveVariantDefinition -> new DanceMoveInstructionText(danceMoveVariantDefinition, new TimeSignature("4/4"), getMessages())).collect(Collectors.toList());
    }
}
