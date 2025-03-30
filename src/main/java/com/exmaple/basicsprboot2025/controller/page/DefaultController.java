package com.exmaple.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //This means this class is Controller!!!
public class DefaultController {
    //This is page controller

    @RequestMapping("/index") // when client call '/index' page plaese execute this method!!
    public String index() {
        return "index"; //find index.html in resources/tamplates/~~~
    }

    @RequestMapping("/test001")
    public String test001() {
        return "test001";
    }

    @RequestMapping("/testmodel")
    public String testmodel(Model model) {
        model.addAttribute("msg", "we are testing!!");
        model.addAttribute("sum", 123);
        return "testmodel";
    }

    @RequestMapping("/testparameter")
    public String testparameter(int a, //parameter
                                int b, //parameter
                                @RequestParam String c, //parameter (reqired)
                                Model model //you can use MVC pattern Model!!
    ) {
        int result = 0;
        result = a + b;
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);
        return "testparameter";
    }
}
