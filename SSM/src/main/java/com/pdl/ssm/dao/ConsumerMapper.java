package com.pdl.ssm.dao;

import com.pdl.ssm.pojo.Consumer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Date: 2023/1/30 19:40
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public interface ConsumerMapper {
    List<Consumer> selectAll();

    void updateBalance(@Param("id") Integer id,@Param("balance") Double balance);

    void updateOneItem(Consumer consumer);
}
