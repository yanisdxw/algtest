package com.study.java;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonTest {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        System.out.println(isObjectNodeEmpty(objectNode));
        objectNode.put("xxx",1);
        System.out.println(isObjectNodeEmpty(objectNode));

        List<String> objects = new ArrayList<>();
        objects.add("1");
        objects.removeIf(n->n.equals("1"));
        System.out.println(objects);

        Integer h = Integer.parseInt("012");
        System.out.println(h);

        String[] strs = StringUtils.split("https://wyydjpk.qiyukf.net/93bc03fe9ac239c7309b18d996188a68.wav","/");
        for (String s:strs){
            System.out.println(s);
        }
    }

    private static boolean isObjectNodeEmpty(ObjectNode objectNode){
        Iterator<String> iterator = objectNode.fieldNames();
        if(iterator.hasNext()){
            return false;
        }else {
            return true;
        }
    }



}
