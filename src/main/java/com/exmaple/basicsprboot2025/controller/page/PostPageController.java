package com.exmaple.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.desktop.SystemEventListener;

@RequestMapping("/post")
@Controller
public class PostPageController {
    /*
    /post/create => create ---> String page!!
    page's value ---> "create"   !!!
    * */
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        //PathVariable is some part of url can be stored in a variable
        // If you specify the variable with @PathVariable anotation in advance
        return "post/" + page;
    }

    @RequestMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id){
        System.out.println("id: " + id);
        return "post/" + page;
    }
}
