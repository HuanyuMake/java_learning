package com.pdl.dao;

import com.pdl.pojo.Consumer;

/**
 * Date: 2023/1/28 16:44
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface ConsumerDao {
    Double getBalance(Integer consumerID);

    Consumer getConsumer(Integer consumerId);

    void updateBalance(Integer consumerID, Double price);

    void updateBalance(Consumer consumer, Double price);
}
