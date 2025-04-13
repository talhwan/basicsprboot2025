package com.exmaple.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/post")
@RestController
public class PostRestController {

    int order = 0;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> map) {
        if(map.get("title") == null || (map.get("title") + "").isEmpty()){
            throw new RuntimeException("no param!");
        }
        String title = (String) map.get("title");
        String content = (String) map.get("content");
        String author = (String) map.get("author");

        Map<String, Object> post = new HashMap<String, Object>();
        post.put("title", title);
        post.put("content", content);
        post.put("author", author);
        post.put("id", ++order);
        list.add(post);

        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", 200);
        result.put("id", order);

        return result;
    }

    @RequestMapping("/update")
    public void update(@RequestParam Map<String, Object> map) {
        if(map.get("id") == null || (map.get("id") + "").isEmpty()){
            throw new RuntimeException("no id!");
        }
        int id = Integer.parseInt(map.get("id").toString());
        Map<String, Object> post = detail(id);
        post.put("title", map.get("title"));
        post.put("content", map.get("content"));
        post.put("author", map.get("author"));
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam int id) {
        Map<String, Object> post = detail(id);
        post.remove("title");
        post.remove("content");
        post.remove("author");
    }

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        for(Map<String, Object> each : list){
            int eachId = Integer.parseInt(each.get("id").toString());
            if(eachId == id){
                return each;
            }
        }
        return null;
    }

    @RequestMapping("/list")
    public List<Map<String, Object>> list(String title) { // title is keyword for searching!!

        //1. there is no search keyword
        if(title == null || title.isEmpty()){
            return list;
        }

        //2. keyword exist
        List<Map<String, Object>> returnList = new ArrayList<>();
        for(Map<String, Object> each : list){
            String eachTitle = each.get("title").toString();
            if(eachTitle.contains(title)){
                returnList.add(each);
            }
        }
        return returnList;
    }

}
