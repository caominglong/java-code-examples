package com.banmao.basic_grammar.homework01.smallchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/26 下午9:00
 * @description
 */
public class SmallChanageApp {

    public static void main(String[] args) {
        SmallChanageSys smallChanageSys = new SmallChanageSys();
        // 设置初始金额
        Money money = new Money();
        money.setMoney(1000);
        // 用户输入
        smallChanageSys.userInput(money);
    }


}