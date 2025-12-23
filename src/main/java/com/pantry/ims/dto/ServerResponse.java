package com.pantry.ims.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerResponse {
    private boolean success;
    private String code;
    private String msg;
    private Object data;
}
