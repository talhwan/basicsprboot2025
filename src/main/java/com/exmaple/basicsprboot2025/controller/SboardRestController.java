package com.exmaple.basicsprboot2025.controller;

import com.exmaple.basicsprboot2025.service.SboardService;
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
    SboardRestController(SboardService sboardService){
        this.sboardService = sboardService;
    }

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String,Object> param) {
        return sboardService.create(param);
    }
    @RequestMapping("/update")
    public void update(@RequestParam Map<String,Object> param) {
        sboardService.update(param);
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam int id) {
        sboardService.delete(id);
    }
    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        return sboardService.detail(id);
    }
    @RequestMapping("/list")
    public List<Map<String, Object>> list(String title) {
        return sboardService.list(title);
    }
}
