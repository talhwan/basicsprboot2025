package com.exmaple.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

}
