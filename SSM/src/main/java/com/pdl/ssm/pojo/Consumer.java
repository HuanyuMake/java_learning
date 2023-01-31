package com.pdl.ssm.pojo;

/**
 * Date: 2023/1/30 19:45
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Consumer {
    private Integer id;

    private String name;

    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public Consumer setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer consumer = (Consumer) o;

        if (!id.equals(consumer.id)) return false;
        return name.equals(consumer.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
