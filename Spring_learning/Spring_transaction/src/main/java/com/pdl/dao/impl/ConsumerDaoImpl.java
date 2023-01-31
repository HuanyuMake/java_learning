package com.pdl.dao.impl;

import com.pdl.dao.ConsumerDao;
import com.pdl.pojo.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Date: 2023/1/28 16:45
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Repository
public class ConsumerDaoImpl implements ConsumerDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public ConsumerDaoImpl setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        return this;
    }

    @Override
    public Double getBalance(Integer consumerID) {
        return getConsumer(consumerID).getBalance();
    }

    @Override
    public Consumer getConsumer(Integer consumerId) {
        Consumer consumer = jdbcTemplate.queryForObject("select * from consumers where id = ?",
                new BeanPropertyRowMapper<>(Consumer.class),
                consumerId);
        if(consumer == null) {
            throw new RuntimeException("No such consumer");
        }

        return consumer;
    }

    @Override
    public void updateBalance(Integer consumerID, Double price) {
        jdbcTemplate.update("update consumers set balance = balance - ? where id = ?",
                price,consumerID);
    }

    @Override
    public void updateBalance(Consumer consumer, Double price) {
        updateBalance(consumer.getId(),price);
    }
}
