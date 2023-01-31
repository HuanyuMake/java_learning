package com.pdl.pojo;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
@Component
public class User {
    private String name;

    public User() {
        if(isOutputLifecycle()){
            System.out.println("lifecycle1 实例化");
        }
    }

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Book[] books;

    private String[] hobbies;

    private boolean outputLifecycle;

    public boolean isOutputLifecycle() {
        return outputLifecycle;
    }

    public User setOutputLifecycle(boolean outputLifecycle) {
        this.outputLifecycle = outputLifecycle;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + Arrays.toString(books) +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public User setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public Book[] getBooks() {
        return books;
    }

    public User setBooks(Book[] books) {
        this.books = books;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        if(isOutputLifecycle()){
            System.out.println("lifecycle2 DI");
        }
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public void initMethod(){
        if(isOutputLifecycle()){
            System.out.println("lifecycle3 initialize");

        }
    }

    public void destroyMethod(){
        if(isOutputLifecycle()){
            System.out.println("lifecycle4 destroy");
        }
    }
}
