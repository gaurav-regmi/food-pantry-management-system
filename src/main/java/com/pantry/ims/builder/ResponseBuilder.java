package com.pantry.ims.builder;

import com.pantry.ims.constant.MsgConstant;
import com.pantry.ims.dto.GenericResponse;
import com.pantry.ims.dto.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder {

    public static ResponseEntity<?> response(ServerResponse serverResponse) {
        GenericResponse response = new GenericResponse();
        if (serverResponse.isSuccess()) {
            response.setCode(MsgConstant.Status.SUCCESS);
            response.setSuccess(true);
            response.setMsg(serverResponse.getMsg());
            response.setData(serverResponse.getData());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setCode(MsgConstant.Status.FAILED);
            response.setSuccess(false);
            response.setMsg(serverResponse.getMsg());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
