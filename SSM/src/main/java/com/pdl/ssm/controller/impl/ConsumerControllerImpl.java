package com.pdl.ssm.controller.impl;

import com.pdl.ssm.FBInterface.CommonResponseBody;
import com.pdl.ssm.controller.ConsumerController;
import com.pdl.ssm.pojo.Consumer;
import com.pdl.ssm.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Date: 2023/1/30 17:48
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@RestController
public class ConsumerControllerImpl implements ConsumerController{
    private final ConsumerService consumerService;
    @Autowired
    public ConsumerControllerImpl(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public CommonResponseBody getAllConsumer(){
        return new CommonResponseBody(consumerService.getAllConsumer());
    }
    @RequestMapping(value = "/consumer/{id}/balance",method = RequestMethod.PUT)
    public CommonResponseBody editBalance(@PathVariable("id") Integer id, @RequestBody Consumer consumer){
        System.out.println("consumer.getBalance() "+consumer.getBalance());
        consumerService.updateBalance(id,consumer.getBalance());
        return new CommonResponseBody();
    }
}
