package com.pkg3;

public class Father {
    void say() {
        System.out.println("father");
    }

    public static void main(String[] args) {
        Father s1 = new Son1();
        Father s2 = new Son2();
//        s1.say();
    }
}
