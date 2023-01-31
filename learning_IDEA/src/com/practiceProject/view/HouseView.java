package com.practiceProject.view;

import com.practiceProject.model.House;
import com.practiceProject.service.HouseService;
import com.practiceProject.utils.CustomScanner;

public class HouseView {

    private boolean mainMenuDisplay = true;

    private HouseService service = new HouseService(100);

    private String[] mainMenuString = {
            "==========房屋出租系统菜单==========",
            "\t\t\t1 新 增 房 源",
            "\t\t\t2 查 找 房 屋",
            "\t\t\t3 删 除 房 屋 信 息",
            "\t\t\t4 修 改 房 屋 信 息",
            "\t\t\t5 房 屋 列 表",
            "\t\t\t6 退 出",
            "请输入你的选择:"
    };

    public void mainMenu() {
        CustomScanner scanner = new CustomScanner();
        do {
            for (int i = 0; i < mainMenuString.length; i++) {
                System.out.println(mainMenuString[i]);
            }
            switch (scanner.readChar()) {
                case '1':
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
                case '5':
                    houseList();
                    break;
                case '6':
                    mainMenuDisplay = false;
                    break;
            }
        } while (mainMenuDisplay);
        System.out.println("你已退出本系统");
    }

    public void houseList() {
        System.out.println("===========房 屋 列 表===========");
        House[] houseList = service.readHouseList();
        for (int i = 0; i < service.getValidNum(); i++) {
            System.out.println(houseList[i]);
        }
    }

}
