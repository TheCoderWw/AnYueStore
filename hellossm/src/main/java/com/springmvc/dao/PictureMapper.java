package com.springmvc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PictureMapper {
    List<String> getPicList(int commId);

    String getPicOne(int commId);

    String getPicColor(int commId);

    String getPicByCart(@Param("commId")int commId,@Param("commColor")String commColor);
}
