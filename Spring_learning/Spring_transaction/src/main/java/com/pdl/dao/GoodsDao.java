package com.pdl.dao;

import com.pdl.pojo.Goods;

/**
 * Date: 2023/1/28 16:14
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface GoodsDao {
    Double getPrice(Integer goodID);

    Integer getStock(Integer goodID);

    Goods getGoods(Integer goodId);

    void updateStock(Integer goodID,Integer delta);
    void updateStock(Goods goods,Integer delta);
}
