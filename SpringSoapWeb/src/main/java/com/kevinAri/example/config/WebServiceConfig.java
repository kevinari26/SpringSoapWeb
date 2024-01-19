package com.kevinAri.example.config;

import com.kevinAri.example.soapStubs.constant.WsConstant;
import com.kevinAri.example.soapStubs.constant.WsConstant2;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    public static final String locationUri = "/ws";

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext appContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(appContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, locationUri+"/*");
    }

    @Bean(name = "soapweb-1")
    public DefaultWsdl11Definition soapWeb1Wsdl(XsdSchema soapWeb1Schema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SoapWeb1Port");
        wsdl11Definition.setLocationUri(locationUri);
        wsdl11Definition.setTargetNamespace(WsConstant.NAMESPACE_URI);
        wsdl11Definition.setSchema(soapWeb1Schema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapWeb1Schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/soapweb-1.xsd"));
    }




    @Bean(name = "soapweb-2")
    public DefaultWsdl11Definition soapWeb2Wsdl(XsdSchema soapWeb2Schema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SoapWeb2Port");
        wsdl11Definition.setLocationUri(locationUri);
        wsdl11Definition.setTargetNamespace(WsConstant2.NAMESPACE_URI);
        wsdl11Definition.setSchema(soapWeb2Schema);

        // suffix request response: opsional
        // harus sama dengan suffix yang didefinisikan pada file .xsd
        // default value nya Request Response
        // contoh request: dummy2Request
        wsdl11Definition.setRequestSuffix("Request");
        wsdl11Definition.setResponseSuffix("Response");

        return wsdl11Definition;
    }

    @Bean
    public XsdSchema soapWeb2Schema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/soapweb-2.xsd"));
    }
}
