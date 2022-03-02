package com.mule.proxy.rest.api.domain;

import java.util.Map;

public interface ProxyService {
    String sendExportBillingData(String soapReq, Map<String, String> reqHeaders);
    String sendProcessWorkResponseMessage(String soapReq, Map<String, String> reqHeaders);
}
