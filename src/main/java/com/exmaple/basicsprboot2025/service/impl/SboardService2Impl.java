package com.exmaple.basicsprboot2025.service.impl;

import com.exmaple.basicsprboot2025.domain.Sboard;
import com.exmaple.basicsprboot2025.repository.SboardRepository;
import com.exmaple.basicsprboot2025.service.SboardService2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SboardService2Impl implements SboardService2 {

    final SboardRepository sboardRepository;
    public SboardService2Impl(SboardRepository sboardRepository) {
        this.sboardRepository = sboardRepository;
    }

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");

        /*Sboard sboard = new Sboard();
        sboard.setTitle(title);*/
        Sboard sboard = new Sboard(title, content, author);
        sboardRepository.save(sboard);

        Map<String, Object> result = new HashMap<>();
        result.put("id", sboard.getId());

        return result;
    }
    @Override
    public void update(Map<String, Object> param) {
        Long tempId = Long.parseLong((String) param.get("id"));
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        if(sboard != null) {
            if(param.get("title") != null){
                String title = (String) param.get("title");
                sboard.setTitle(title);
            }
            if(param.get("content") != null){
                String content = (String) param.get("content");
                sboard.setContent(content);
            }
            if(param.get("author") != null){
                String author = (String) param.get("author");
                sboard.setAuthor(author);
            }
            sboardRepository.save(sboard);
        }

    }
    @Override
    public void delete(int id) {
        Long tempId = (long) id;
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        if(sboard != null) {
            sboardRepository.delete(sboard);
        }
    }
    /*@Override
    public Map<String, Object> detail(int id) {
        Long tempId = (long) id;
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        Map<String, Object> result = new HashMap<>();
        result.put("sboard", sboard);
        return result;
    }*/
    @Override
    public Sboard detail(int id) {
        Long tempId = (long) id;
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        return sboard;
    }
    /*@Override
    public List<Map<String, Object>> list(String title) {
        return List.of();
    }*/
    @Override
    public List<Sboard> list() {
        List<Sboard> sboardList = sboardRepository.findAll();
        return sboardList;
    }
}
