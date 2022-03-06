package com.mule.proxy.rest.api.driving;


import com.mule.proxy.rest.api.domain.ProxyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class ProxyController {

    private ProxyService proxyService;

    @PostMapping(value = "/exportBillingData",  consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> exportBillingData(@RequestBody String soapReq, @RequestHeader  Map<String, String> reqHeaders)   {
        Object soapResponse = proxyService.sendExportBillingData(soapReq,reqHeaders);

        log.info("MDMS MeterRead is processed");
        return new ResponseEntity<>(soapResponse, HttpStatus.OK);
    }
    @PostMapping(value = "/processWorkResponseMessage",  consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> processWorkResponseMessage(@RequestBody String soapReq, @RequestHeader  Map<String, String> reqHeaders)   {
        Object soapResponse = proxyService.sendProcessWorkResponseMessage(soapReq,reqHeaders);
        
        log.info("MDMS Meter Activation is processed");
        return new ResponseEntity<>(soapResponse, HttpStatus.ACCEPTED);
    }
}
