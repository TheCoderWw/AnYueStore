package com.springmvc.service;

import com.springmvc.pojo.PageBean;

public interface PageService {

    PageBean getGoodsList(String goodsName,int pageNow);
}
