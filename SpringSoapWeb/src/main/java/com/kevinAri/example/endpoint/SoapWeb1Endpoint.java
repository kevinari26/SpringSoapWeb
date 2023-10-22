package com.kevinAri.example.endpoint;

import com.kevinAri.example.service.AppService;
import com.kevinAri.example.soapStubs.constant.WsConstant;
import com.kevinAri.example.soapStubs.dto.forTesting.DummyRequest;
import com.kevinAri.example.soapStubs.dto.forTesting.DummyResponse;
import com.kevinAri.example.soapStubs.dto.queryGeneric.InquiryGenericRequest;
import com.kevinAri.example.soapStubs.dto.queryGeneric.InquiryGenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapWeb1Endpoint {
    @Autowired
    AppService appService;


    // soapweb-1
    @PayloadRoot(namespace = WsConstant.NAMESPACE_URI, localPart = WsConstant.DummyRequest)
    @ResponsePayload
    public DummyResponse response(@RequestPayload DummyRequest request) {
        return appService.response(request);
    }

    @PayloadRoot(namespace = WsConstant.NAMESPACE_URI, localPart = WsConstant.InquiryGenericRequest)
    @ResponsePayload
    public InquiryGenericResponse response(@RequestPayload InquiryGenericRequest request) {
        return appService.response(request);
    }
}
