package com.kevinAri.example.soapClient;


import com.wsimport.soap1.DummyRequest;
import com.wsimport.soap1.DummyResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapWeb1Client extends WebServiceGatewaySupport {
    public DummyResponse dummyRequest(DummyRequest request) {
        return (DummyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, null);
    }
}
