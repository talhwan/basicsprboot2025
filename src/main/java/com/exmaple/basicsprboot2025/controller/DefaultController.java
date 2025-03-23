package com.exmaple.basicsprboot2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DefaultController {

    @ResponseBody // return JSON type!! not a view!!! (RestController)
    @RequestMapping("/test")
    public String test(){
        return "test123";
    }

    @ResponseBody // return JSON type!! not a view!!! (RestController)
    @RequestMapping("test2")
    public Map<String, Object> test2(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        return map;
    }

    @RequestMapping("/page1") //return view!!! (Page Controller)
    public String page1(){
        return "page1";
    }

}
