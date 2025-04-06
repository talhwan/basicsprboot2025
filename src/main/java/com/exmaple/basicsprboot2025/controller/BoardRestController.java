package com.exmaple.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {

    //CRUD C create R read U update D delete
    int order = 0;
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); // for keep data temporally

    @RequestMapping("/create")
    public Map<String, Object> create(String title, String content, String author){
        System.out.println("create");

        Map<String, Object> board = new HashMap<>();
        board.put("title", title);
        board.put("content", content);
        board.put("author", author);
        //board.put("id", list.size() + 1);
        board.put("id", ++order);

        list.add(board);

        Map<String, Object> returnValue = new HashMap<String, Object>();
        returnValue.put("resultCode", 200);
        return returnValue;
    }

    @RequestMapping("/update")
    public void update(String id, String title, String content, String author){
        System.out.println("update");
        /*
        int index = Integer.parseInt(id) - 1;
        Map<String, Object> board = list.get(index);
        */
        Map<String, Object> board = detail(id);
        if(title != null && !title.isEmpty()){
            board.put("title", title);
        }
        if(content != null && !content.isEmpty()){
            board.put("content", content);
        }
        if(author != null && !author.isEmpty()){
            board.put("author", author);
        }
    }

    @RequestMapping("/delete")
    public void delete(String id){
        System.out.println("delete");
        /*
        #1.
        int index = Integer.parseInt(id) - 1;
        list.remove(index);
        */
        /*
        int index = 0;
        list.remove(index);
        for(Map<String, Object> each : list){
            if((each.get("id") + "").equals(id)){
                list.remove(index);
            }
            index++;
        }
        */
        //#3
        Map<String, Object> board = detail(id);
        board.remove("title");
        board.remove("content");
        board.remove("author");
    }

    @RequestMapping("/detail")
    public Map<String, Object> detail(String id){
        System.out.println("detail");
        /*int index = Integer.parseInt(id) - 1;
        Map<String, Object> board = list.get(index);*/
        for(Map<String, Object> each : list){
            if((each.get("id") + "").equals(id)){
                return each;
            }
        }
        return null;
    }

    @RequestMapping("/list")
    public List<Map<String, Object>> list(){
        System.out.println("list");
        return list;
    }

}
