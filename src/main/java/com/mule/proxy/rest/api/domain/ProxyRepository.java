package com.mule.proxy.rest.api.domain;

import java.util.Map;

public interface ProxyRepository {

    String postExportBillingData(String soapReq, Map<String, String> reqHeaders);
    String postProcessWorkResponseMessage(String soapReq, Map<String, String> reqHeaders);

}
