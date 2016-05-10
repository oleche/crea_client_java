package com.creaengine.iot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by oleche on 11/14/15.
 */
public class SessionResponse {
    private String code;
    private String expires;
    @JsonProperty("access_token")
    private String accessToken;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
