package com.practiceProject.service;

import com.practiceProject.model.House;

public class HouseService {
    private House HouseDataBase[];
    private int validNum;

    public HouseService(int range) {
        if (range > 0) {
            HouseDataBase = new House[range];
            initDB(5);
        } else {
            System.out.println("warn db range");
        }
    }

    public House[] readHouseList() {
        return HouseDataBase;
    }

    private void initDB(int range) {
        validNum = range;
        for (int i = 0; i < range; i++) {
            HouseDataBase[i] = House.initHouse(HouseDataBase);
        }
    }

    public int getValidNum() {
        return validNum;
    }
}
