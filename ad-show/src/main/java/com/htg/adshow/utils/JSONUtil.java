package com.htg.adshow.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtil {

    public static String convertObject(Object object) {
        String content = "{}";
        ObjectMapper mapper=new ObjectMapper();
        try {
            content = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return content;
        }

        return content;
    }


}
