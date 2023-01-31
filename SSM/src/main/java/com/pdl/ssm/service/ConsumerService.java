package com.pdl.ssm.service;

import com.pdl.ssm.pojo.Consumer;

import java.util.List;

/**
 * Date: 2023/1/30 18:39
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface ConsumerService {
    List<Consumer> getAllConsumer();

    void updateBalance(Integer id, Double balance);
}
