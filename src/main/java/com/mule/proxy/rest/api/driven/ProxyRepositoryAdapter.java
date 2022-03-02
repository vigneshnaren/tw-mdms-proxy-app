package com.mule.proxy.rest.api.driven;

import com.mule.proxy.rest.api.domain.ProxyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class ProxyRepositoryAdapter implements ProxyRepository  {

    private FeignClientConfiguration feignClientConfiguration;

    private FeignClientOauthConfiguration feignClientOauthConfiguration;

   @Autowired
   private Environment env;

    @Override
    public String postExportBillingData(String soapReq, Map<String, String> reqHeaders) {

          Map<String,String> resHeaders = new HashMap<>();

          //GET Auth Token
          Map<String,String> obj=  feignClientOauthConfiguration.getToken(
                  env.getProperty("token.granttype"),
                  new String(Base64.getDecoder().decode(env.getProperty("token.client.id").getBytes())),
                  new String(Base64.getDecoder().decode(env.getProperty("token.client.secret").getBytes())),
                  env.getProperty("token.scope")
                 );

            resHeaders.put("Authorization", "Bearer " + obj.get("access_token"));
            resHeaders.put("client_id",new String(Base64.getDecoder().decode(env.getProperty("mdmsxapi.client_id").getBytes())));
            resHeaders.put("client_secret",new String(Base64.getDecoder().decode(env.getProperty("mdmsxapi.client_secret").getBytes())));

            return feignClientConfiguration.exportBillingDatatoMDMS(soapReq,resHeaders);
    }

    @Override
    public String postProcessWorkResponseMessage(String soapReq, Map<String, String> reqHeaders) {
        Map<String,String> resHeaders = new HashMap<>();

        //GET Auth Token
        Map<String,String> obj=  feignClientOauthConfiguration.getToken(
                env.getProperty("token.granttype"),
                new String(Base64.getDecoder().decode(env.getProperty("token.client.id").getBytes())),
                new String(Base64.getDecoder().decode(env.getProperty("token.client.secret").getBytes())),
                env.getProperty("token.scope")
        );

        resHeaders.put("Authorization", "Bearer " + obj.get("access_token"));
        resHeaders.put("client_id",new String(Base64.getDecoder().decode(env.getProperty("mdmsxapi.client_id").getBytes())));
        resHeaders.put("client_secret",new String(Base64.getDecoder().decode(env.getProperty("mdmsxapi.client_secret").getBytes())));

        return feignClientConfiguration.ProcessWorkResponseMessagetoMDMS(soapReq,resHeaders);
    }


}

