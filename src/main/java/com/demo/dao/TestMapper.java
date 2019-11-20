package com.demo.dao;

import com.demo.dataobject.UserDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {
    @Select("select * from Test")
    List<UserDo> query();
}
