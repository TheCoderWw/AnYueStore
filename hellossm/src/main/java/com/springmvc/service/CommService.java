package com.springmvc.service;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.Commodity;


public interface CommService {
    Commodity getCommById(int id) throws MyException;
}
