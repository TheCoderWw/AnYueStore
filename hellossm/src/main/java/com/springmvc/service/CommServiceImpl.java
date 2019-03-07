package com.springmvc.service;

import com.springmvc.dao.*;
import com.springmvc.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommServiceImpl implements CommService {
    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private TopMapper topMapper;

    @Autowired
    private BottomMapper bottomMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public Commodity getCommById(int id) throws MyException {
        Commodity commodity = commodityMapper.getCommById(id);
        if(commodity == null){
            throw new MyException("没有该商品");
        }
        if (commodity.getClassifyId() == 3 || commodity.getClassifyId() == 5) {
            commodity.setAllSizeList(topMapper.getSizeList(id));
            commodity.setInventoryList(topMapper.getInventoryList(id));
        } else {
            commodity.setAllSizeList(bottomMapper.getWaistLine(id));
            commodity.setInventoryList(bottomMapper.getInventoryList(id));
        }
        commodity.setAllPicAddress(pictureMapper.getPicList(id));
        System.out.println(commodity);
        return commodity;
    }
}
