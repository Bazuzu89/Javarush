package com.javarush.task.task22.task2208;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        LinkedHashMap<String, String> query = new LinkedHashMap<>();
        query.put("name", "Ivanov");
        query.put("country", "Ukraine");
        query.put("city", "Kiev");
        query.put("age", null);
        getQuery(query);
        System.out.println(getQuery(query));
    }

    public static String getQuery(Map<String, String> params) {

        ArrayList<String> strings = new ArrayList<>();
        for (String key : params.keySet()) {
            if (params.get(key) != null) {
                String line = key + " = "  + "'" + params.get(key)  + "'";
                strings.add(line);
            }
        }
        String output = String.join(" and ", strings);
        return output;
    }
}
