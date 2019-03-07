package com.springmvc.dao;

import com.springmvc.pojo.PageBean;
import com.springmvc.pojo.SearchGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageBeanMapper {
    int getBeanAllNum(String goodsName);

//    List<SearchGoods> getGoodsByPageNow(@Param("pageBean")PageBean pageBean,@Param("goodsName")String goodsName);

    List<SearchGoods> getGoodsByPageNow(@Param("goodsName")String goodsName,@Param("pageNow")int pageNow,@Param("pageSize")int pageSize);
}
