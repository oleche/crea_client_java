package com.creaengine.iot.http;

import com.creaengine.iot.model.ExecuteResponse;
import com.creaengine.iot.model.ModuleBaseResponse;
import com.creaengine.iot.model.SessionResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by oleche on 11/14/15.
 */
public interface CreaService {

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = "application/x-www-form-urlencoded",
            value = "/session")
    SessionResponse session(@RequestHeader("Authorization") String authorization, String body);

    @RequestMapping(method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = "application/x-www-form-urlencoded",
            value = "/module/{id}/execute-action")
    ExecuteResponse execute(@RequestHeader("Authorization") String authorization, @PathVariable("id") String id, String body);

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = "application/x-www-form-urlencoded",
            value = "/module/{id}")
    ModuleBaseResponse getInfo(@RequestHeader("Authorization") String authorization, @PathVariable("id") String id);

}
