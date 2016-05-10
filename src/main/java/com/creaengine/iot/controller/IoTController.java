package com.creaengine.iot.controller;

import com.creaengine.iot.http.Controller.CreaClient;
import com.creaengine.iot.http.CreaService;
import com.creaengine.iot.model.CommonResponse;
import com.creaengine.iot.model.ExecuteResponse;
import com.creaengine.iot.model.ModuleBaseResponse;
import com.creaengine.iot.model.SessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.sun.xml.wss.impl.misc.Base64;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IoTController {

    @Autowired
    private CreaClient client;
    @Value("${creaengine.key:d760d6389c153add4bc3021d725f6a6a}") String key;
    @Value("${creaengine.secret:96af37198c2104f982c708da4c338736}") String secret;
    @Value("${creaengine.module:1a943d9e22adf7785f2e9d458a2c1287}") String module;
    @Value("${creaengine.enviar:117}") String enviar;


    @RequestMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }

    public String getBasic(){
        String token = key + ":" + secret;
        token = "Basic " + Base64.encode(token.getBytes());
        System.out.println(token);
        return token;

    }

    @RequestMapping("/info")
    public CommonResponse info(){
        SessionResponse session = client.session(getBasic(),"scopes=module-owner");
        ModuleBaseResponse module = client.getInfo("Bearer "+session.getAccessToken(),this.module);
        CommonResponse response = new CommonResponse();
        response.setResponse(module.getModulos().get(0).getRespuesta());
        return response;
    }

    @RequestMapping("/process")
    public CommonResponse process(@RequestParam(value="name", defaultValue="S") String value){
        SessionResponse session = client.session(getBasic(),"scopes=module-owner");
        ExecuteResponse execute = client.execute("Bearer " + session.getAccessToken(), this.module, "value="+value+"&action="+enviar);
        CommonResponse response = new CommonResponse();
        response.setResponse(execute.getMessage());
        return response;
    }
    
}
