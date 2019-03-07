package com.springmvc.service;

import com.springmvc.dao.TopMapper;
import com.springmvc.pojo.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopServiceImpl implements TopService {
    @Autowired
    private TopMapper topMapper;

    @Override
    public List<String> getSizeListById(int id) {
        return topMapper.getSizeList(5);
    }
}
