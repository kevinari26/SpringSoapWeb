package com.kevinAri.example.util;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CommonUtil {
    public static Date currentDateTime() {
        return new Date(System.currentTimeMillis());
    }
    public static XMLGregorianCalendar currentDateTimeXml() {
        try {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(currentDateTime());
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        } catch (Exception e) {
            return null;
        }
    }
}
