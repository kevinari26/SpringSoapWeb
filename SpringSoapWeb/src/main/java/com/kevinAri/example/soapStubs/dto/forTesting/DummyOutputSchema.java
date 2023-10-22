package com.kevinAri.example.soapStubs.dto.forTesting;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
public class DummyOutputSchema {
    @XmlElement(required = true)
    private Date requestTime;

    @XmlElement(required = true)
    private Date responseTime;

    @XmlElement(required = true)
    private String stringOutput;

    @XmlElement(required = true)
    private Integer integerOutput;

    @XmlElement(required = true)
    private BigDecimal bigDecimalOutput;
}
