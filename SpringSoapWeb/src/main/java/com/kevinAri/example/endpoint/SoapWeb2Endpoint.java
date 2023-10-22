package com.kevinAri.example.endpoint;

import com.kevinAri.example.config.WebServiceConfig;
import com.kevinAri.example.service.AppService;
import com.soap.soapWeb2.Dummy2Request;
import com.soap.soapWeb2.Dummy2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapWeb2Endpoint {
    @Autowired
    AppService appService;

    // soapweb-2
    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI_2, localPart = "dummy2Request")
    @ResponsePayload
    public Dummy2Response response(@RequestPayload Dummy2Request request) {
        return appService.response(request);
    }
}
