package com.dev.internal.common.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.util.UUID;

@ControllerAdvice
public class UUIDInitBinder {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(UUID.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (text == null || text.isEmpty()) {
                    setValue(null);
                } else {
                    try {
                        setValue(UUID.fromString(text));
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Invalid UUID string: " + text);
                    }
                }
            }
        });
    }
}
