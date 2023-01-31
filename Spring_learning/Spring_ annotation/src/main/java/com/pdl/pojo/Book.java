package com.pdl.pojo;

import org.springframework.stereotype.Component;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
public class Book {
    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        int num = (int)(Math.random()*10+1);
        this.name = name + num;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Book setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
