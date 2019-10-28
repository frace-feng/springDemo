package com.frace.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by frace on 2019/10/28 11:28
 */
@Getter
@Setter
public class Response {
    private int code;
    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
