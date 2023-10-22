package com.kevinAri.example.soapStubs.dto.queryGeneric;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
public class InquiryGenericOutputSchema {
    @XmlElement(required = true)
    private List<String> columnName;
    @XmlElement(required = true)
    private List<TypeData> listData;

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TypeData {
        List<String> value;
    }
}