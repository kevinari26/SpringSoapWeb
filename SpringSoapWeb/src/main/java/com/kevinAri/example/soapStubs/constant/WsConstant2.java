package com.kevinAri.example.soapStubs.constant;

import javax.xml.namespace.QName;

public interface WsConstant2 {
    String NAMESPACE_URI = "http://www.kevinari.com/soapweb-2";

    // request response
    String Dummy2Request = "Dummy2Request";
    String Dummy2Response = "Dummy2Response";
    String Dummy3Request = "Dummy3Request";
    String Dummy3Response = "Dummy3Response";

    // qname
    QName Dummy3Request_QName = new QName(NAMESPACE_URI, Dummy3Request);
    QName Dummy3Response_QName = new QName(NAMESPACE_URI, Dummy3Response);
}
