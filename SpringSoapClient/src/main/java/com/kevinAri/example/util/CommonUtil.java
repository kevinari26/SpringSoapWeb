package com.kevinAri.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class CommonUtil {
    public static void errorMaker() {
        try {
//        String bigDecStr = null;
//        BigDecimal bigDecimal = new BigDecimal(bigDecStr);
//        Integer temp = 1/0;
            CommonUtil2.errorMaker2();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue("12345:'asd'", Object.class);
        } catch (Exception e) {
            Integer temp = 1/0;
        }
    }
    private static void errorMaker2() {
        Integer temp = 1/0;
    }
}
