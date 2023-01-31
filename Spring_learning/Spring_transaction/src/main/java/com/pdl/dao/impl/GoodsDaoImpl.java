package com.pdl.dao.impl;

import com.pdl.dao.GoodsDao;
import com.pdl.pojo.Consumer;
import com.pdl.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Date: 2023/1/28 16:15
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Repository
public class GoodsDaoImpl implements GoodsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public GoodsDaoImpl setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        return this;
    }

    @Override
    public Double getPrice(Integer goodID) {
        return getGoods(goodID).getPrice();
    }

    @Override
    public Integer getStock(Integer goodID) {
        return getGoods(goodID).getStock();
    }

    @Override
    public Goods getGoods(Integer goodId) {
        Goods goods = jdbcTemplate.queryForObject("select * from goods where id = ?",
                new BeanPropertyRowMapper<>(Goods.class),
                goodId);
        if(goods == null) {
            throw new RuntimeException("No such goods");
        }
        return goods;
    }

    @Override
    public void updateStock(Integer goodID, Integer delta) {
        jdbcTemplate.update("update goods set stock = stock + ? where id = ?",
                delta, goodID);
    }

    @Override
    public void updateStock(Goods goods, Integer delta) {
        updateStock(goods.getId(),delta);
    }
}
