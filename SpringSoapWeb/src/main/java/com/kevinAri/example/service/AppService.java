package com.kevinAri.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinAri.example.soapStubs.constant.WsConstant2;
import com.kevinAri.example.soapStubs.dto.forTesting.DummyOutputSchema;
import com.kevinAri.example.soapStubs.dto.forTesting.DummyRequest;
import com.kevinAri.example.soapStubs.dto.forTesting.DummyResponse;
import com.kevinAri.example.soapStubs.dto.queryGeneric.InquiryGenericOutputSchema;
import com.kevinAri.example.soapStubs.dto.queryGeneric.InquiryGenericRequest;
import com.kevinAri.example.soapStubs.dto.queryGeneric.InquiryGenericResponse;
import com.kevinAri.example.util.CommonUtil;
import com.kevinAri.example.util.ResponseHelper;
import com.soap.soapWeb2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AppService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ResponseHelper responseHelper;

    // soapweb-1
    public DummyResponse response(DummyRequest request) {
        DummyResponse response = new DummyResponse();
        DummyOutputSchema outputSchema = new DummyOutputSchema();

        try {
            outputSchema.setRequestTime(request.getRequestTime());
            outputSchema.setResponseTime(CommonUtil.currentDateTime());
            outputSchema.setStringOutput(request.getStringInput());
            outputSchema.setIntegerOutput(request.getIntegerInput());
            outputSchema.setBigDecimalOutput(request.getBigDecimalInput());

            response.setOutputSchema(outputSchema);

            responseHelper.setResponseMessage("S001", null, response);
        } catch (Exception e) {
            e.printStackTrace();
            responseHelper.setResponseMessage("E002", null, response);
        }

        return response;
    }

    public InquiryGenericResponse response(InquiryGenericRequest request) {
        InquiryGenericResponse response = new InquiryGenericResponse();
        InquiryGenericOutputSchema outputSchema = new InquiryGenericOutputSchema();

        try {
            InquiryGenericOutputSchema.TypeData typeData = new InquiryGenericOutputSchema.TypeData();
            List<InquiryGenericOutputSchema.TypeData> typeDataList = new ArrayList<>();

            typeData.setValue(new ArrayList<>(Arrays.asList("val1", "val2")));
            typeDataList.add(typeData);

            typeData.setValue(new ArrayList<>(Arrays.asList("val11", "val22")));
            typeDataList.add(typeData);

            outputSchema.setListData(typeDataList);
            outputSchema.setColumnName(Arrays.asList("column1", "column2"));

            response.setOutputSchema(outputSchema);

            responseHelper.setResponseMessage("S001", null, response);
        } catch (Exception e) {
            e.printStackTrace();
            responseHelper.setResponseMessage("E002", null, response);
        }

        return response;
    }


    // soapweb-2
    public Dummy2Response response(Dummy2Request request) {
        Dummy2Response response = new Dummy2Response();
        Dummy2OutputSchema outputSchema = new Dummy2OutputSchema();
        ErrorSchemaXsd errorSchema = new ErrorSchemaXsd();

        try {
            outputSchema.setRequestTime(request.getRequestTime());
            outputSchema.setResponseTime(CommonUtil.currentDateTimeXml());
            outputSchema.setStringOutput(request.getStringInput());
            outputSchema.setIntegerOutput(request.getIntegerInput());
            outputSchema.setBigDecimalOutput(request.getBigDecimalInput());

            response.setOutputSchema(outputSchema);

            errorSchema.setErrorCode("200");
            errorSchema.setErrorMessage("success");
        } catch (Exception e) {
            e.printStackTrace();
            errorSchema.setErrorCode("500");
            errorSchema.setErrorMessage("internal server error");
        }

        response.setErrorSchema(errorSchema);
        return response;
    }

    public JAXBElement<String> response(JAXBElement<String> request) {
        JAXBElement<String> response;

        try {
            response = new JAXBElement<>(WsConstant2.Dummy3Response_QName, String.class, request.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            response = new JAXBElement<>(WsConstant2.Dummy3Response_QName, String.class, "Error");
        }

        return response;
    }
}
