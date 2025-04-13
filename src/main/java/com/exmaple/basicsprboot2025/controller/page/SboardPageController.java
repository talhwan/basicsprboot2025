package com.exmaple.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sboard")
@Controller
public class SboardPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return "sboard/" + page;
    }
    @RequestMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) {
        return "sboard/" + page;
    }
}
