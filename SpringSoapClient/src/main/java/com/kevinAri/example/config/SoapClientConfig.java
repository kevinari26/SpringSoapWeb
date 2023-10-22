package com.kevinAri.example.config;

import com.kevinAri.example.config.properties.WsdlClientProperties;
import com.kevinAri.example.soapClient.SoapWeb1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;


@Configuration
public class SoapClientConfig {
    @Autowired
    WsdlClientProperties wsdlClientProperties;

    private void buildClient(WebServiceGatewaySupport client, WsdlClientProperties.WsdlClientProperty wsdlEsbProperty) {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(wsdlEsbProperty.getPackageName());

        client.setDefaultUri(wsdlEsbProperty.getEndpoint());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
    }

    @Bean
    public SoapWeb1Client soapWeb1Client() {
        SoapWeb1Client client = new SoapWeb1Client();
        buildClient(client, wsdlClientProperties.getSoapWeb1());
        client.setMessageSender(noAuthMS());
        return client;
    }


    @Bean
    public HttpComponentsMessageSender noAuthMS() {
        // config basic auth dan timeout
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
//        messageSender.setCredentials(new UsernamePasswordCredentials(wsdlClientProperties.getAmlProcessingEngine().getUsername(), wsdlClientProperties.getAmlProcessingEngine().getPassword()));
        messageSender.setConnectionTimeout(wsdlClientProperties.getConnectTimeout()); // timeout for creating a connection
        messageSender.setReadTimeout(wsdlClientProperties.getRequestTimeout()); // when you have a connection, timeout the read blocks for
        return messageSender;
    }
}
