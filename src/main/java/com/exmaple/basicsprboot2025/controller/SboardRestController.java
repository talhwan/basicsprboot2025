package com.exmaple.basicsprboot2025.controller;

import com.exmaple.basicsprboot2025.domain.Sboard;
import com.exmaple.basicsprboot2025.service.SboardService;
import com.exmaple.basicsprboot2025.service.SboardService2;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/sboard")
@RestController
public class SboardRestController {

    final SboardService sboardService;
    final SboardService2 sboardService2;
    SboardRestController(SboardService sboardService, SboardService2 sboardService2){
        this.sboardService = sboardService;
        this.sboardService2 = sboardService2;
    }

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String,Object> param) {
        //return sboardService.create(param);
        return sboardService2.create(param);
    }
    @RequestMapping("/update")
    public void update(@RequestParam Map<String,Object> param) {
        //sboardService.update(param);
        sboardService2.update(param);
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam int id) {
        //sboardService.delete(id);
        sboardService2.delete(id);
    }
    /*@RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        return sboardService.detail(id);
    }*/
    @RequestMapping("/detail/{id}")
    public Sboard detail(@PathVariable int id) {
        return sboardService2.detail(id);
    }
    /*@RequestMapping("/list")
    public List<Map<String, Object>> list(String title) {
        return sboardService.list(title);
    }*/
    @RequestMapping("/list")
    public List<Sboard> list() {
        return sboardService2.list();
    }
}
