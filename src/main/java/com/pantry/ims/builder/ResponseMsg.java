package com.pantry.ims.builder;

import com.pantry.ims.constant.MsgConstant;
import com.pantry.ims.dto.ServerResponse;

public class ResponseMsg {

    public static ServerResponse failure(String msg) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(false);
        serverResponse.setCode(MsgConstant.Status.FAILED);
        serverResponse.setMsg(msg);

        return serverResponse;
    }

    public static ServerResponse success(String msg) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(true);
        serverResponse.setCode(MsgConstant.Status.SUCCESS);
        serverResponse.setMsg(msg);

        return serverResponse;
    }

    public static ServerResponse success(String msg, Object data) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setSuccess(true);
        serverResponse.setCode(MsgConstant.Status.SUCCESS);
        serverResponse.setMsg(msg);
        serverResponse.setData(data);

        return serverResponse;
    }
}
