package com.springmvc.contorller;

import com.springmvc.pojo.PageBean;
import com.springmvc.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    PageService pageService;

    @CrossOrigin
    @RequestMapping(value = "/goodsList")
    @ResponseBody
    public Map<String, Object> getGoodsListByName(@RequestParam("goodsName") String goodsName, @RequestParam("page") int pageNow) {
        Map<String, Object> map = new HashMap<>();
        PageBean pageBean = pageService.getGoodsList(goodsName, pageNow);
        map.put("status", 200);
        map.put("pageBean", pageBean);
        return map;
    }
}
