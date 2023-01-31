package com.pdl.ssm.pojo;

/**
 * Date: 2023/1/30 21:33
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Goods {
    private Integer id;

    private String name;

    private Double price;

    private Integer stock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods goods)) return false;

        if (!getId().equals(goods.getId())) return false;
        if (!getName().equals(goods.getName())) return false;
        if (!getPrice().equals(goods.getPrice())) return false;
        return getStock().equals(goods.getStock());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getStock().hashCode();
        return result;
    }

    public Goods() {
    }

    public Goods(Integer id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
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
