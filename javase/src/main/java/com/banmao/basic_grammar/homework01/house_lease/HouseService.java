package com.banmao.basic_grammar.homework01.house_lease;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/28 下午8:32
 * @description
 */
public class HouseService {

    private final List<House> houseList = new ArrayList<>();


    public List<House> getHouseList() {
        return houseList;
    }

    public boolean addHouse(House house) {
        int i = idCounter(houseList.size());
        house.setNumber(i);
        houseList.add(house);
        return true;
    }

    public boolean deleteHouse(int number) {
        boolean deleteFLag = false;
        Iterator iterator = houseList.iterator();
        while (iterator.hasNext()) {
            House house = (House) iterator.next();
            if (number == house.getNumber()) {
                iterator.remove();
                deleteFLag = true;
            }
        }
        if (!deleteFLag) {
            System.out.println("未找到此编号的房屋，请确认输入是否正确？");
        }
        return true;
    }

    public House findHouse(int number) {
        Iterator iterator = houseList.iterator();
        while (iterator.hasNext()) {
            House house = (House) iterator.next();
            if (number == house.getNumber()) {
                return house;
            }
        }
        return null;
    }

//    public House updateHouse(int number) {
//        Iterator iterator = houseList.iterator();
//        while (iterator.hasNext()) {
//            House house = (House) iterator.next();
//            if (number == house.getNumber()) {
//                return house;
//            }
//        }
//        return null;
//
//    }

    /**
     * id自增长
     * @return
     */
    private int idCounter(int size) {
        return size + 1;
    }
}