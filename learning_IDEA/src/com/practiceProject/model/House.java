package com.practiceProject.model;

import java.util.Arrays;
import java.util.Random;

public class House {
    private int id;
    private String name;

    private String phone;
    private String address;

    private int rent;

    private String state;

    public House(int id, String name, String phone, String address, int rent, String state) {
        setId(id);
        setName(name);
        setPhone(phone);
        setAddress(address);
        setRent(rent);
        setState(state);
    }

    static public House initHouse(House[] db) {
        int randomInt = new Random().nextInt(db.length + 1);
        String id = null;
        try {
            id = "@" + db.length + 1 + randomInt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        String b = new String("ok");
        b.intern();
        return new House(db.length + 1 + randomInt, "name" + id, "phone" + id, "address" + id, randomInt * 100, "未出租");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        String range[] = {
                "已出租",
                "未出租"
        };
        Arrays.sort(range);
        if (Arrays.binarySearch(range, state) != -1) {
            this.state = state;
        } else {
            System.out.println("请输入已出租/未出租");
        }
    }

    @Override
    public String toString() {
        return id +
                "\t" + name +
                "\t" + phone +
                "\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}
