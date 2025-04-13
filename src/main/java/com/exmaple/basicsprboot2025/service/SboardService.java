package com.exmaple.basicsprboot2025.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SboardService {
    Map<String, Object> create(Map<String,Object> param);
    void update(Map<String,Object> param);
    void delete(int id);
    Map<String, Object> detail(int id);
    List<Map<String, Object>> list(String title);
}
