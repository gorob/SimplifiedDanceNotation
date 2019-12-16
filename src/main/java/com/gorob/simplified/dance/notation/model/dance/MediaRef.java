package com.gorob.simplified.dance.notation.model.dance;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MediaRef {
    private MediaService service;
    private MediaType mediaType;
    private String ref;
}
