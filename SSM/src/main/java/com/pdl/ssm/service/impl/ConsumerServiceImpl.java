package com.pdl.ssm.service.impl;

import com.pdl.ssm.dao.ConsumerMapper;
import com.pdl.ssm.pojo.Consumer;
import com.pdl.ssm.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Date: 2023/1/30 18:38
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService {
    private final ConsumerMapper consumerMapper;
    @Autowired
    public ConsumerServiceImpl(ConsumerMapper consumerMapper) {
        this.consumerMapper = consumerMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Consumer> getAllConsumer(){
        return consumerMapper.selectAll();
    }

    @Override
    public void updateBalance(Integer id, Double balance) {
        consumerMapper.updateOneItem(new Consumer().setId(id).setBalance(balance));
    }
}
