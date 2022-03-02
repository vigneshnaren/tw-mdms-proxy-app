package com.mule.proxy.rest.api.driven;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@FeignClient(url = "${target.endpoint}", name="sendSoapReq")
public interface FeignClientConfiguration {

    @PostMapping(value = "${target.meterRead}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
     String exportBillingDatatoMDMS(@RequestBody String soapReq, @RequestHeader Map<String,String> s);

    @PostMapping(value = "${target.meterActivation}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    String ProcessWorkResponseMessagetoMDMS(@RequestBody String soapReq, @RequestHeader Map<String,String> s);
}
