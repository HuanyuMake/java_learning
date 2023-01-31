package com.pdl.ssm.service.impl;

import com.pdl.ssm.dao.GoodsMapper;
import com.pdl.ssm.pojo.Goods;
import com.pdl.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date: 2023/1/30 21:44
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Goods> getAllGoods() {
        return goodsMapper.selectAll();
    }

    @Override
    public void updateStock(Integer id, Integer stock) {
        goodsMapper.updateOneItem(new Goods().setId(id).setStock(stock));
    }
}
