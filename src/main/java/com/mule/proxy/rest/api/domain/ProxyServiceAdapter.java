package com.mule.proxy.rest.api.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ProxyServiceAdapter implements ProxyService {

    private ProxyRepository proxyRepository;



    @Override
    public String sendExportBillingData(String soapReq, Map<String, String> reqHeaders) {
        return proxyRepository.postExportBillingData(soapReq,reqHeaders);
    }

    @Override
    public String sendProcessWorkResponseMessage(String soapReq, Map<String, String> reqHeaders) {
        return proxyRepository.postProcessWorkResponseMessage(soapReq,reqHeaders);
    }
}
