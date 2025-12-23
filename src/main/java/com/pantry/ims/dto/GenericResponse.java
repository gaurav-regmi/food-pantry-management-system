package com.pantry.ims.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse extends ModelBase {
    private Object data;
    private String code;
    private String msg;
    private boolean success;
}
