package com.pdl.ssm.controller;

import com.pdl.ssm.FBInterface.CommonResponseBody;
import com.pdl.ssm.pojo.Consumer;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Date: 2023/1/30 21:32
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface ConsumerController {
    CommonResponseBody getAllConsumer();

    CommonResponseBody editBalance(Integer id, Consumer consumer);


}
