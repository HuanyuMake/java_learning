package com.pdl.pojo;

import org.springframework.stereotype.Component;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
public class Organization {
    private Integer id;
    private String name;

    public Organization setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Organization setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organization setName(String name) {
        this.name = name;
        return this;
    }
}
