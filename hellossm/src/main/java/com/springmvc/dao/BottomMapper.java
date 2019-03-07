package com.springmvc.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BottomMapper {
    List<String> getWaistLine(int id);
    List<Integer> getInventoryList(int id);
    void deleteInven(@Param("commId") int commId,@Param("commSize") String commSize,@Param("commNum") int commNum);

    void addInven(@Param("commId") int commId,@Param("commSize") String commSize,@Param("commNum") int commNum);
    int selectInven(@Param("commId") int commId,@Param("commSize") String commSize);
}
