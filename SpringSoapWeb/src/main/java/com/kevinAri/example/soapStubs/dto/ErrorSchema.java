package com.kevinAri.example.soapStubs.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@Setter
@Getter

@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorSchema {
    private String ErrorCode;
    private String ErrorMessage;
}
