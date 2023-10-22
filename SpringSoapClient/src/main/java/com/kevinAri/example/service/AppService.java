package com.kevinAri.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinAri.example.soapClient.SoapWeb1Client;
import com.wsimport.soap1.DummyRequest;
import com.wsimport.soap1.DummyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class AppService {
    @Autowired
    ObjectMapper objectMapper;

    // soap client
    @Autowired
    SoapWeb1Client soapWeb1Client;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void execute() {
        try {
//            log.info("app service");
//            TIMESTAMP temp = null;
//            System.out.println(temp.stringValue());
//            List<String> splitted = Arrays.asList("MA, JA".split(","));
//            System.out.println(log.getName());
//            System.out.println(log.toString());
            hitSoapWeb1();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void hitSoapWeb1() {
        try {
            DummyRequest request = new DummyRequest();
            request.setStringInput("str in");
            request.setIntegerInput(1);
            request.setBigDecimalInput(new BigDecimal("2.34"));
            DummyResponse response = soapWeb1Client.dummyRequest(request);
            System.out.println(objectMapper.writeValueAsString(response));
        } catch (Exception e) {

        }
    }

    public static void errorLog(Logger log, Exception e) {
        log.error("");
        log.error("=== Error Log ===");
        log.error("Cause: {}", e.toString());
        for (StackTraceElement stack : e.getStackTrace()) {
            log.error("Stack: {}", stack);
        }
        Throwable rootCause = e.getCause();
        while (rootCause!=null) {
            log.error("RootCause: {}", rootCause.toString());
            for (StackTraceElement stack : rootCause.getStackTrace()) {
                log.error("Stack: {}", stack);
            }
            rootCause = rootCause.getCause();
        }
        log.error("");
    }

}
