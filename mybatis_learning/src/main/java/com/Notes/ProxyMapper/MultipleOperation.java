package com.Notes.ProxyMapper;

import com.DB.User;
import com.Mapper.UsersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class MultipleOperation {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);

//        List<User> users = usersMapper.selectAll();

        /*String [] names = {"小明","小黄"};
        List<User> users = usersMapper.selectByNames(names);*/

        Map<String, User> stringUserMap = new HashMap<>();

        stringUserMap.put("user",new User("小明"));

        List<User> users = usersMapper.selectUserByMap(stringUserMap);

        System.out.println(users);

        sqlSession.close();
    }
}
