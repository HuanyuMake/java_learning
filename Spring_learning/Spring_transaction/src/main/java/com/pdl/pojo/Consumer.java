package com.pdl.pojo;

/**
 * Date: 2023/1/28 16:36
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Consumer {
    private Integer id;

    private String name;

    private Double balance;

    public Consumer() {
    }

    public Consumer(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public Consumer setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Consumer setName(String name) {
        this.name = name;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public Consumer setBalance(Double balance) {
        this.balance = balance;
        return this;
    }
}
