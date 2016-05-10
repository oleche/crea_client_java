package com.creaengine.iot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by oleche on 11/14/15.
 */
public class ModuleBaseResponse {
    private String code;
    @JsonProperty("http_code")
    private String httpCode;
    List<ModuleResponse> modulos;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    public List<ModuleResponse> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuleResponse> modulos) {
        this.modulos = modulos;
    }
}
