package com.springmvc.contorller;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.Commodity;
import com.springmvc.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/comm")
public class CommController {
    @Autowired
    private CommService commService;


    @RequestMapping(value = "/getCommInfo")
    @ResponseBody
    public Map<String, Object> getCommInfo(@RequestParam("id") int commId) {
        Map<String, Object> map = new HashMap<>();
        try {
            Commodity commodity = commService.getCommById(commId);
            map.put("status", 200);
            map.put("commodity", commodity);
        } catch (MyException e) {
            map.put("status", 201);
            map.put("message", e.getMessage());
        }
        return map;
    }
}
