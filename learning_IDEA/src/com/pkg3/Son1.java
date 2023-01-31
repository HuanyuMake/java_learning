package com.pkg3;

public class Son1 extends Father {
    int age = 10;


    @Override
    void say() {
        System.out.println("Son1");
    }

    void fn1() {
        System.out.println("fn1");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Son1 son1 = (Son1) o;

        return age == son1.age;
    }

    @Override
    public int hashCode() {
        return age;
    }
}
