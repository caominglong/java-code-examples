package com.banmao.basic_grammar.homework01.house_lease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/28 下午7:39
 * @description 相当于MVC三层架构的Controller
 */
public class HouseView {

    private boolean flag = true;
    private HouseService houseService = new HouseService();

    public static void main(String[] args) {

        HouseView houseView = new HouseView();


            houseView.showMenu();

    }

    /**
     * 显示菜单
     */
    public void showMenu() {
        do {
            System.out.println("----------房屋出租系统-----------");
            System.out.println("1\t新增房源");
            System.out.println("2\t查找房屋");
            System.out.println("3\t删除房屋");
            System.out.println("4\t修改房屋信息");
            System.out.println("5\t房屋列表");
            System.out.println("6\t退   出");
            System.out.println("\t输出你的选择[1-6]:");
            char key = Utility.readChar();
            switch (key) {
                case '1':
                    System.out.println("新增");
                    this.addHouseHandle();
                    break;
                case '2':
                    System.out.println("查找");
                    this.queryHouseHandle();
                    break;
                case '3':
                    System.out.println("删除房屋");
                    this.deleteHouseHandle();
                    break;
                case '4':
                    System.out.println("修改房屋信息");
                    this.editHouseHandle();
                    break;
                case '5':
                    System.out.println("房屋列表");
                    this.houseList();
                    break;
                case '6':
                    System.out.println("退出");
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误！");
                    break;
            }
        } while (flag);
    }

    /**
     * 新增房源
     */
    public void addHouseHandle() {
        System.out.println("==============添加房屋==============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String iphone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(16);
        System.out.println("月租：");
        int rent = Utility.readInt(1000);
        System.out.println("状态：");
        int status = Utility.readInt(0);

        House house = new House(0, name, iphone, address, rent, (byte)status);
        if (houseService.addHouse(house)) {
            System.out.println("===========添加房屋成功============");
        }
    }

    /**
     * 查找房屋
     */
    public void queryHouseHandle() {
        System.out.println("请输入待查找房屋的编号（-1退出）:");
        int number = Utility.readInt(3);
        if (number == -1) {
            System.out.println("放弃查找房屋信息");
            return;
        }
        House house = houseService.findHouse(number);
        if (house == null) {
            System.out.println("通过number:" + number + "未能查找到房屋信息");
        } else {
            System.out.println(house.toString());
        }
    }

    /**
     * 删除房屋
     */
    public void deleteHouseHandle() {
        System.out.println("===========删除房屋信息============");
        System.out.println("请输入待删除房屋的编号（-1退出）:");
        int number = Utility.readInt(3);
        if (number == -1) {
            System.out.println("放弃删除房屋信息");
            return;
        }

        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            houseService.deleteHouse(number);
            System.out.println("删除房屋信息成功");
        } else {
            System.out.println("放弃删除房屋信息");
        }
    }

    /**
     * 修改房屋信息
     */
    public void editHouseHandle() {
        System.out.println("请输入待修改房屋的编号（-1退出）:");
        int number = Utility.readInt(3);
        if (number == -1) {
            System.out.println("放弃查找房屋信息");
            return;
        }
        House house = houseService.findHouse(number);
        if (house == null) {
            System.out.println("通过number:" + number + "未能查找到房屋信息");
        }
        System.out.println("姓名("+house.getHouseOwner()+")");
        String houseOwner = Utility.readString(10, "");
        if (!"".equals(houseOwner)) {
            house.setHouseOwner(houseOwner);
        }
        System.out.println("电话("+house.getIphone()+")");
        String iphone = Utility.readString(12, "");
        if (!"".equals(iphone)) {
            house.setIphone(iphone);
        }
        System.out.println("地址("+house.getAddress()+")");
        String address = Utility.readString(12, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.println("租金("+house.getMonthlyRent()+")");
        int rent = Utility.readInt(-1);
        if (!(rent == -1)) {
            house.setMonthlyRent(rent);
        }
        System.out.println("状态("+house.getStatus()+")");
        int status = Utility.readInt(-1);
        if (!(status == -1)) {
            house.setStatus((byte)rent);
        }
        System.out.println("============修改房屋信息成功==========");
    }

    /**
     * 房屋列表
     */
    public void houseList() {
        List<House> houseList = houseService.getHouseList();
        // 先将房屋列表按照需要从小到大排序
        Collections.sort(houseList);
        System.out.println("===========房屋列表===========");
        System.out.println("编号\t\t\t房主\t\t\t电话\t\t\t地址\t\t\t月租\t\t\t状态");
        for (int i = 0; i < houseList.size(); i++) {

            System.out.println(houseList.get(i).getNumber() + "\t\t\t"
                    + houseList.get(i).getHouseOwner() + "\t\t\t"
                    + houseList.get(i).getIphone() + "\t\t\t"
                    + houseList.get(i).getAddress() + "\t\t\t"
                    + houseList.get(i).getMonthlyRent() + "\t\t\t"
                    + (houseList.get(i).getStatus() == 0 ? "未出租":"已出租")
            );
        }
        System.out.println();
    }

    /**
     * 退出
     */
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            flag = false;
        }
    }
}