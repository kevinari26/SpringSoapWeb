package com.kevinAri.example.soapStubs.dto.queryGeneric;

import com.kevinAri.example.soapStubs.constant.WsConstant;
import com.kevinAri.example.soapStubs.dto.ErrorSchema;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = WsConstant.InquiryGenericResponse)
public class InquiryGenericResponse {
    private ErrorSchema errorSchema;
    private InquiryGenericOutputSchema outputSchema;
}