package com.kevinAri.example.soapClient;


import com.wsimport.soap2.Dummy2Request;
import com.wsimport.soap2.Dummy2Response;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SoapWeb2Client extends WebServiceGatewaySupport {
    public Dummy2Response dummyRequest(Dummy2Request request) {
        return (Dummy2Response) getWebServiceTemplate()
                .marshalSendAndReceive(request, null);
    }
}
