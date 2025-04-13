package com.exmaple.basicsprboot2025.service.impl;

import com.exmaple.basicsprboot2025.service.SboardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SboardServiceImpl implements SboardService {

    int order = 0;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    public Map<String, Object> create(Map<String, Object> param) {
        if(param.get("title") == null){
            throw new RuntimeException("no title");
        }
        Map<String, Object> sboard = new HashMap<String, Object>();
        String title = (String) param.get("title");
        sboard.put("title", title);
        if(param.get("content") != null){
            sboard.put("content", (String) param.get("content"));
        }
        if(param.get("author") != null){
            sboard.put("author", (String) param.get("author"));
        }
        sboard.put("id", ++order);
        list.add(sboard);

        Map<String, Object> returnValue = new HashMap<>();
        returnValue.put("resultCode", 200);
        returnValue.put("id", sboard.get("id"));

        return returnValue;
    }

    @Override
    public void update(Map<String, Object> param) {
        int id = Integer.parseInt(param.get("id").toString());
        Map<String, Object> sboard = detail(id);
        if(sboard != null){
            if(param.get("title") != null || !((String) param.get("title")).isEmpty()){
                sboard.put("title", param.get("title"));
            }
            if(param.get("content") != null || !((String) param.get("content")).isEmpty()){
                sboard.put("content", param.get("content"));
            }
            if(param.get("author") != null || !((String) param.get("author")).isEmpty()){
                sboard.put("author", param.get("author"));
            }
        }
    }

    @Override
    public void delete(int id) {
        Map<String, Object> sboard = detail(id);
        if(sboard != null){
            sboard.remove("title");
            sboard.remove("content");
            sboard.remove("author");
        }
    }

    @Override
    public Map<String, Object> detail(int id) {
        for(Map<String, Object> each : list){
            int eachId = (int) each.get("id");
            if(eachId == id){
                return each;
            }
        }
        return null;
    }

    @Override
    public List<Map<String, Object>> list(String title) {
        if(title == null || title.isEmpty()){
            return list;
        } else {
            List<Map<String, Object>> newList = new ArrayList<>();
            for(Map<String, Object> each : list){
                if(title.contains(each.get("title").toString())){
                    newList.add(each);
                }
            }
            return newList;
        }
    }

}
