package com.Mapper;

import com.DB.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface UsersMapper {
    List<User> selectAll();

//    如果想在 mapper.xml 里使用到这个 自定义名为 names 的数组, 需要用如下形式
    List<User> selectByNames(@Param("names") String[] names);

    List<User> selectUserByMap(Map<String,User> map);
}
