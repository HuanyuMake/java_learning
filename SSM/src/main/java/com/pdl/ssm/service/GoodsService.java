package com.pdl.ssm.service;

import com.pdl.ssm.pojo.Consumer;
import com.pdl.ssm.pojo.Goods;

import java.util.List;

/**
 * Date: 2023/1/30 21:43
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface GoodsService {
    List<Goods> getAllGoods();

    void updateStock(Integer id, Integer stock);
}
