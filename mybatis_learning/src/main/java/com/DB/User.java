package com.DB;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {}
}
