package com.pdl.test;

import com.pdl.controller.GoodsController;
import com.pdl.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Date: ${DATE} ${TIME}
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
//指定当前测试类的运行环境,此时可以通过DI直接获取Bean,而不需要先获得IOC后通过IOC来获取Bean
@RunWith(SpringJUnit4ClassRunner.class)
//指定Spring IOC上下文所使用的配置文件
//@ContextConfiguration("classpath:appCtx-spring-jdbc.xml")
@ContextConfiguration("classpath:appCtx-tx-annotation.xml")
public class Main {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private GoodsController goodsController;

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Test
    public void add(){
        int insertUpdateNum = jdbcTemplate.update("insert into users values (null,?)", "张三");
        System.out.println(insertUpdateNum);
    }

    @Test
    public void queryOneObject(){
        User user = jdbcTemplate.queryForObject("select * from users where id = ?",
                new BeanPropertyRowMapper<>(User.class),
                1);
        System.out.println(user);
    }

    @Test
    public void queryFromList(){
        List<User> users = jdbcTemplate.query("select * from users",
                new BeanPropertyRowMapper<>(User.class));
//        System.out.println(users);
        users.forEach(System.out::println);
//        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void buyGoods() throws InterruptedException {

        try {
            goodsController.buyBook(2,2);
            // 使用 TimeUnit工具类来单位化执行休眠, 测试超时后的强制回滚
            // 超时前置回滚后会抛出 TransactionTimedOutException 异常
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            TimeUnit.SECONDS.sleep(5);
        }
    }

}