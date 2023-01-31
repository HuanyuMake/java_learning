package com.pdl.service.impl;

import com.pdl.dao.ConsumerDao;
import com.pdl.dao.GoodsDao;
import com.pdl.pojo.Consumer;
import com.pdl.pojo.Goods;
import com.pdl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2023/1/28 16:15
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Service
//@Transactional
public class GoodsServiceImpl implements GoodsService {

    private GoodsDao goodsDao;

    private ConsumerDao consumerDao;

    public static class NotEnoughBalance extends RuntimeException {
        NotEnoughBalance(int consumerID){
            super("notEnoughBalance. consumer ID "+consumerID);
        }
    }

    public static class NotEnoughStock extends RuntimeException {
        NotEnoughStock(int goodID){
            super("notEnoughStock. goods ID: "+ goodID);
        }
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }
    @Autowired
    public GoodsServiceImpl setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        return this;
    }

    public ConsumerDao getConsumerDao() {
        return consumerDao;
    }

    @Autowired
    public GoodsServiceImpl setConsumerDao(ConsumerDao consumerDao) {
        this.consumerDao = consumerDao;
        return this;
    }

    @Override
    @Transactional(
            timeout = 3, //设置超时时间为3s
            // 不因为这个异常对象而回滚, 就是当抛出这个异常时,不进行回滚
            // 如果有多个异常对象要填写,只需展开写成 {E1,E2,E3,...,En} 就行,
            // 对于注解的数组类型赋值,,只有一个元素可以只写一个元素
//            noRollbackFor = ArithmeticException.class,
            noRollbackFor = {ArithmeticException.class, org.springframework.transaction.TransactionTimedOutException.class}
    )
    public void buyGood(Integer consumerID, Integer goodID) {
        try {
            // 使用 TimeUnit工具类来单位化执行休眠, 测试超时后的强制回滚
            // 超时前置回滚后会抛出 TransactionTimedOutException 异常
            TimeUnit.SECONDS.sleep(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Consumer consumer = consumerDao.getConsumer(consumerID);
        Goods goods = goodsDao.getGoods(goodID);

        Double balance = consumer.getBalance();

        Double price = goods.getPrice();
        Integer stock = goods.getStock();

        if(balance < price) {
            throw new NotEnoughBalance(consumerID);
        }
        if(stock == 0) {
            throw new NotEnoughStock(goodID);
        }
        consumerDao.updateBalance(consumerID, goods.getPrice());
        goodsDao.updateStock(goodID,-1);

        System.out.println(1/0);
    }

    public void buyGood(Consumer consumer, Goods goods) {
        buyGood(consumer.getId(),goods.getId());
    }
}
