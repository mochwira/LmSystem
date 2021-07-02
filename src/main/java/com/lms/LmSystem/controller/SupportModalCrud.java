package com.lms.LmSystem.controller;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SupportModalCrud {

    public Map<String, String> config(String add, String edit, String replace, String  remove, String delete){

        Map<String, String> aMap = new HashMap<String, String>();
        aMap.put("add" , add);
        aMap.put("edit", edit);
        aMap.put("replace", replace);
        aMap.put("remove", remove);
        aMap.put("delete", delete);

        System.out.println(aMap);
        return aMap;
    }
}
