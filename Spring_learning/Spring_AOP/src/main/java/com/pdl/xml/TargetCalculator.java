package com.pdl.xml;

import com.pdl.Calculator;
import org.springframework.stereotype.Component;

/**
 * Date: 2023/1/27 21:44
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
public class TargetCalculator implements Calculator {
    @Override
    public double add(double i, double j) {
        System.out.println("执行 add 核心代码");
        return i + j;
    }

    @Override
    public double sub(double i, double j) {
        System.out.println("执行 sub 核心代码");
        return i - j;
    }

    @Override
    public double mul(double i, double j) {
        System.out.println("执行 mul 核心代码");
        return i * j;
    }

    @Override
    public double div(double i, double j) {
        System.out.println("执行 div 核心代码");
        return i / j;
    }
}
