package com.springmvc.service;

import com.springmvc.dao.PageBeanMapper;
import com.springmvc.dao.PictureMapper;
import com.springmvc.pojo.PageBean;
import com.springmvc.pojo.SearchGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageBean pageBean;

    @Autowired
    private PageBeanMapper pageBeanMapper;

    @Override
    public PageBean getGoodsList(String goodsName, int pageNow) {
        pageBean.setPageNow(pageNow);
        pageBean.setPageSize(15);
        pageBean.setSum(pageBeanMapper.getBeanAllNum("%" + goodsName + "%"));
        String newGoodsName = "%" + goodsName + "%";

        List<SearchGoods> goodsList = pageBeanMapper.getGoodsByPageNow(newGoodsName, pageNow, 15);
        pageBean.setGoodsList(goodsList);

        return pageBean;
    }
}
