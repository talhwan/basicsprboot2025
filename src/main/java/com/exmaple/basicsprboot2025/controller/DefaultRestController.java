package com.exmaple.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api") // automatically added every method request mapping!! (like prefix)
@RestController //this means this class is REST controller!!
public class DefaultRestController {
    //this is RestController

    @RequestMapping("/index1")
    public int index1(){
        return 1; //return OBJECT!! (JSON type)
    }

    @RequestMapping("/test1")
    public List<String> test1(@RequestParam String param1, String param2){
        List<String> list = new ArrayList<String>();
        list.add("test1");
        list.add("test1-1");
        list.add("test1-2");
        list.add(param1);
        list.add(param2);
        return list;
    }

    /*
    Create a rest controller that accesses the address api => '/api/assignment2'
    Create it so that it returns a Map object containing multiple pieces of information.
    * */

    @RequestMapping("/assignment2")
    public Map<String, Object> assignment2(){
        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("key1", "value1");
        returnValue.put("key2", "value2");
        return returnValue;
    }

    @RequestMapping("/assignment3")
    public int assignment3(@RequestParam int num1, @RequestParam int num2, @RequestParam int num3){
        int sum = num1 + num2 + num3;
        return sum;
    }


}
