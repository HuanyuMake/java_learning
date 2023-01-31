package com.pdl.ssm.controller.impl;

import com.pdl.ssm.FBInterface.CommonResponseBody;
import com.pdl.ssm.controller.GoodsController;
import com.pdl.ssm.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Date: 2023/1/30 21:36
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@RestController
public class GoodsControllerImpl implements GoodsController{

    private final GoodsService goodsService;
    @Autowired
    public GoodsControllerImpl(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public CommonResponseBody getAllGoods() {
        return new CommonResponseBody(goodsService.getAllGoods()) ;
    }

    @RequestMapping(value = "/goods/{id}/stock",method = RequestMethod.PUT)
    public CommonResponseBody editStock(@PathVariable("id") Integer id, @RequestBody Map<String,Integer> goods){
        goodsService.updateStock(id,goods.get("stock"));
        return new CommonResponseBody();
    }


}
