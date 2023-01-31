package com.pdl.ssm.dao;

import com.pdl.ssm.pojo.Goods;

import java.util.List;

/**
 * Date: 2023/1/30 21:36
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface GoodsMapper {
    List<Goods> selectAll();

    void updateOneItem(Goods goods);
}
