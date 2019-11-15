package com.demo.dao;

import com.demo.dataobject.UserDo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from User")
    List<UserDo> query();
}
