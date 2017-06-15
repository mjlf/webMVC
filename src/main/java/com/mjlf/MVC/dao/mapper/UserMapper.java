package com.mjlf.MVC.dao.mapper;

import com.mjlf.MVC.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by a123 on 17/6/15.
 * 用户mapper 类
 */
@Mapper
public interface UserMapper {

    /**
     * 通过name 查找用户值
     * @param name
     * @return
     */
    @Select("SELECT id, name, phone FROM user where name = #{name}")
    public User findName(@Param("name") String name);
}
