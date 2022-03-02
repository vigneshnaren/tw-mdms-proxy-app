package com.mule.proxy.rest.api.driven;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Map;


@FeignClient(url = "${oauth.endpoint}", name="token")
public interface FeignClientOauthConfiguration {


    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, String> getToken(@RequestPart("grant_type") String grant_type,
                                 @RequestPart("client_id") String client_id,
                                 @RequestPart("client_secret") String client_secret,
                                 @RequestPart("scope") String scope
                                   );
}
