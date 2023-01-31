package com.pdl.pojo;

/**
 * Date: 2023/1/28 16:33
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Goods {
    private Integer id;

    private String name;

    private Double price;
    private Integer stock;

    public Goods() {
    }

    public Goods(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Goods setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Goods setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Goods setStock(Integer stock) {
        this.stock = stock;
        return this;
    }
}
