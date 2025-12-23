package com.pantry.ims.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Component;

@Component
public class ModelBase {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
