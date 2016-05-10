package com.creaengine.iot.http.Controller;

import com.creaengine.iot.http.CreaService;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by oleche on 11/14/15.
 */
@FeignClient(url = "${com.creaengine.iot.endpoint:http://www.creaengine.com/v1}")
public interface CreaClient extends CreaService{
}
