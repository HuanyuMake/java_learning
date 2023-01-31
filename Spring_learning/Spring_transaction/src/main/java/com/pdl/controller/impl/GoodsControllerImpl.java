package com.pdl.controller.impl;

import com.pdl.controller.GoodsController;
import com.pdl.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Date: 2023/1/28 16:13
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Controller
public class GoodsControllerImpl implements GoodsController {
    private GoodsService goodsService;

    public GoodsService getGoodsService() {
        return goodsService;
    }
    @Autowired
    public GoodsControllerImpl setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
        return this;
    }

    public void buyBook(Integer consumerID,Integer goodID) {
        goodsService.buyGood(consumerID,goodID);
    }
}
