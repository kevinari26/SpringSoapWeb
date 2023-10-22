package com.kevinAri.example.soapStubs.dto.forTesting;

import com.kevinAri.example.soapStubs.constant.WsConstant;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = WsConstant.DummyRequest)
public class DummyRequest {
    @XmlElement(required = true)
    private Date requestTime;

    @XmlElement(required = true)
    private String stringInput;

    @XmlElement(required = true)
    private Integer integerInput;

    @XmlElement(required = true)
    private BigDecimal bigDecimalInput;
}
