package com.springmvc.dao;

import com.springmvc.pojo.Commodity;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityMapper {
    Commodity getCommById(int id);
}
