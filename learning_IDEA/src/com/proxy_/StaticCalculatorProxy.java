package com.proxy_;

/**
 * Date: 2023/1/27 21:46
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class StaticCalculatorProxy implements Calculator {
    final Calculator target;

    public StaticCalculatorProxy(Calculator target) {
        this.target = target;
    }


    @Override
    public double add(double i, double j) {
        System.out.println("[日志]: 执行了 add 方法, 入参 i " + i + " j" + j);
        final double result = target.add(i, j);
        System.out.println("[日志]: 执行了 add 方法, 结果 " + result);
        return result;
    }

    @Override
    public double sub(double i, double j) {
        System.out.println("[日志]: 执行了 sub 方法, 入参 i " + i + " j" + j);
        final double result = target.sub(i, j);
        System.out.println("[日志]: 执行了 sub 方法, 结果 " + result);
        return result;
    }

    @Override
    public double mul(double i, double j) {
        System.out.println("[日志]: 执行了 mul 方法, 入参 i " + i + " j" + j);
        final double result = target.mul(i, j);
        System.out.println("[日志]: 执行了 mul 方法, 结果 " + result);
        return result;
    }

    @Override
    public double div(double i, double j) {
        System.out.println("[日志]: 执行了 div 方法, 入参 i " + i + " j" + j);
        final double result = target.div(i, j);
        System.out.println("[日志]: 执行了 din 方法, 结果 " + result);
        return result;
    }
}
