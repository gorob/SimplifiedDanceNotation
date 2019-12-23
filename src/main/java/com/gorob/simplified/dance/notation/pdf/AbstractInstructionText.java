package com.gorob.simplified.dance.notation.pdf;

import com.gorob.simplified.dance.notation.messages.Messages;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.List;

@Getter(AccessLevel.PROTECTED)
public abstract class AbstractInstructionText {
    private static final String INSTRUCTION_TEXT_PART_KEY_AND = "INSTRUCTION_TEXT_PART_AND";
    private static final String INSTRUCTION_TEXT_PART_KEY_CLIP_BEGIN = "INSTRUCTION_TEXT_PART_CLIP_BEGIN";
    private static final String INSTRUCTION_TEXT_PART_KEY_CLIP_END = "INSTRUCTION_TEXT_PART_CLIP_END";
    private static final String INSTRUCTION_TEXT_PART_KEY_AT_THE_END = "INSTRUCTION_TEXT_PART_AT_THE_END";

    private Messages messages;

    public AbstractInstructionText(Messages messages){
        this.messages = messages;
    }

    protected String getInstructionTextAnd(){
        return getMessages().getMessage(INSTRUCTION_TEXT_PART_KEY_AND);
    }

    protected String getInstructionTextClipBegin(){
        return getMessages().getMessage(INSTRUCTION_TEXT_PART_KEY_CLIP_BEGIN);
    }

    protected String getInstructionTextClipEnd(){
        return getMessages().getMessage(INSTRUCTION_TEXT_PART_KEY_CLIP_END);
    }

    protected String getInstructionTextAtTheEnd(){
        return getMessages().getMessage(INSTRUCTION_TEXT_PART_KEY_AT_THE_END);
    }
}
