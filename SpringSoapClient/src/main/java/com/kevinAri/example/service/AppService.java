package com.kevinAri.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinAri.example.soapClient.SoapWeb1Client;
import com.kevinAri.example.soapClient.SoapWeb2Client;
import com.wsimport.soap1.DummyRequest;
import com.wsimport.soap1.DummyResponse;
import com.wsimport.soap2.Dummy2Request;
import com.wsimport.soap2.Dummy2Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


@Service
public class AppService {
    @Autowired
    ObjectMapper objectMapper;

    // soap client
    @Autowired
    SoapWeb1Client soapWeb1Client;
    @Autowired
    SoapWeb2Client soapWeb2Client;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void execute() {
        try {
//            System.out.println("soap1:");
//            hitSoapWeb1();
//            System.out.println("soap2:");
//            hitSoapWeb2();
            hitSoapWithRawHttp();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void hitSoapWeb1() throws Exception {
        DummyRequest request = new DummyRequest();
        request.setStringInput("str in");
        request.setIntegerInput(1);
        request.setBigDecimalInput(new BigDecimal("2.34"));
        DummyResponse response = soapWeb1Client.dummyRequest(request);
        System.out.println(objectMapper.writeValueAsString(response));
    }

    private void hitSoapWeb2() throws Exception {
        Dummy2Request request = new Dummy2Request();
        request.setStringInput("str in 2");
        request.setIntegerInput(2);
        request.setBigDecimalInput(new BigDecimal("3.34"));
        Dummy2Response response = soapWeb2Client.dummyRequest(request);
        System.out.println(objectMapper.writeValueAsString(response));
    }

    public void hitSoapWithRawHttp() {
        String wsURL = "http://localhost:8080/ws";

        try {
            // Set connection
            URLConnection urlConn = new URL(wsURL).openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;

            // autentikasi
//            httpConn.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE2Njc0NzI4NzQsImlhdCI6MTY2NzQ3Mjc1NH0.-NMVbOnWLWU8_1QKuxZmhJk_SKAd5wl9smzn9k5wf_gD-qTK_4ZQikYFGsgSivY5DojfzxlY10UgFj3Zl2fFMA");
            // Set the appropriate HTTP parameters.
//            httpConn.setRequestProperty("Accept", "application/json");
            httpConn.setRequestProperty("Accept", "text/xml");
            httpConn.setRequestProperty("Content-Type", "text/xml;charset=utf-8");
//            httpConn.setRequestProperty("SOAPAction", "");
//            httpConn.setRequestProperty("SOAPAction", wsURL+"#");
			httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
//            httpConn.setDoInput(true);


            // Set parameter / body
            String xmlBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://www.kevinari.com/soapweb-1\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <soap:DummyRequest>\n" +
                    "         <soap:requestTime>2023-10-07</soap:requestTime>\n" +
                    "         <soap:stringInput>string</soap:stringInput>\n" +
                    "         <soap:integerInput>132</soap:integerInput>\n" +
                    "         <soap:bigDecimalInput>123.123</soap:bigDecimalInput>\n" +
                    "      </soap:DummyRequest>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
//			String urlParams = "param1=testParam1";
			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
			writer.write(xmlBody);
			writer.flush();

//			OutputStream reqStream = httpConn.getOutputStream();
//            reqStream.write(xmlBody.getBytes());
//			writer.write(urlParams);


            // Read the response and write it to standard out.
//            InputStream resStream = httpConn.getInputStream();
//            byte[] byteBuf = new byte[10240];
//            int len = resStream.read(byteBuf);
            String outputString = "";
            InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String responseString = null;
            while ((responseString = br.readLine()) != null) {
                outputString = outputString + responseString;
            }
            httpConn.disconnect();
			System.out.println(outputString);
        }
        catch (Exception e) {
            e.printStackTrace();
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
