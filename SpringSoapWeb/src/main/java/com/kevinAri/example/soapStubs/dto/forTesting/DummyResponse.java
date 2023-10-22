package com.kevinAri.example.soapStubs.dto.forTesting;

import com.kevinAri.example.soapStubs.constant.WsConstant;
import com.kevinAri.example.soapStubs.dto.ErrorSchema;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = WsConstant.DummyResponse)
public class DummyResponse {
    private ErrorSchema errorSchema;
    private DummyOutputSchema outputSchema;
}
