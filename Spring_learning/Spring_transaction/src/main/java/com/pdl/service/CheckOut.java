package com.pdl.service;

import com.pdl.pojo.Consumer;
import com.pdl.pojo.Goods;

/**
 * Date: 2023/1/28 19:00
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface CheckOut {
    void buyAllGoods(Integer consumer, Goods [] goods);
}
