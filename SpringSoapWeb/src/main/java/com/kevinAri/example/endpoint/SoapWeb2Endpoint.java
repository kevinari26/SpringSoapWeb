package com.kevinAri.example.endpoint;

import com.kevinAri.example.service.AppService;
import com.kevinAri.example.soapStubs.constant.WsConstant2;
import com.soap.soapWeb2.Dummy2Request;
import com.soap.soapWeb2.Dummy2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;

@Endpoint
public class SoapWeb2Endpoint {
    @Autowired
    AppService appService;

    // soapweb-2
    @PayloadRoot(namespace = WsConstant2.NAMESPACE_URI, localPart = WsConstant2.Dummy2Request)
    @ResponsePayload
    public Dummy2Response response(@RequestPayload Dummy2Request request) {
        return appService.response(request);
    }

    @PayloadRoot(namespace = WsConstant2.NAMESPACE_URI, localPart = WsConstant2.Dummy3Request)
    @ResponsePayload
    public JAXBElement<String> response(@RequestPayload JAXBElement<String> request) {
        return appService.response(request);
    }
}
