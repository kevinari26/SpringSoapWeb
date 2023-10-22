package com.kevinAri.example.soapStubs.dto.queryGeneric;

import com.kevinAri.example.soapStubs.constant.WsConstant;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = WsConstant.InquiryGenericRequest)
public class InquiryGenericRequest {
    @XmlElement(required = true)
    private String queryName;
    @XmlElement(required = true)
    private List<TypeParameter> listParameter;

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TypeParameter {
        @XmlElement(required = true)
        private String key;
        @XmlElement(required = true)
        private String value;
    }
}