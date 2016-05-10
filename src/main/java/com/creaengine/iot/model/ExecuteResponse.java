package com.creaengine.iot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by oleche on 11/14/15.
 */
public class ExecuteResponse {
    private String message;
    @JsonProperty("http_code")
    private int httpCode;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
