package com.banmao.basic_grammar.homework01.smallchange;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/26 下午8:59
 * @description 零钱通
 */
public class SmallChanageSys {

    public static List<SmallChanageDetail> smallChanageDetailList = new ArrayList<>();

    public void userInput(Money money) {
        while (true) {
            // 展示菜单
            showMenu();
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 1 :
                    // System.out.println("零钱通明细");
                    this.printDetail(smallChanageDetailList);
                    break;
                case 2:
                    this.income(money);
                    break;
                case 3:
                    this.pay(money);
                    break;
                case 4:
                    this.exit();
                    return;
                default:
                    System.out.println("请输入正确的选择！");
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("\n==============零钱通==============");
        System.out.println("\t\t1 零钱通明细");
        System.out.println("\t\t2 收益入账");
        System.out.println("\t\t3 消费");
        System.out.println("\t\t4 退     出");
        System.out.print("请输入[1-4]选择：");
    }

    public void income(Money money) {
        // 收益入账
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("请输入金额：");
        double money2 = scanner2.nextDouble();
        if (money2 <= 0) {
            System.out.println("收益金额需要大于等于0");
            return;
        }
        this.plusMoney(money, money2);
        String behavior = "收益入账 +" + money2;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(df);
        String moneyDetail = "余额:" + money.getMoney();
        // 工作中，这里更多的是入库（写入数据库）
        SmallChanageDetail smallChanageDetail = new SmallChanageDetail(behavior, format, moneyDetail);
        smallChanageDetailList.add(smallChanageDetail);
    }

    public void pay(Money money) {
        // 消费
        System.out.println("请输入消费说明：");
        Scanner scanner3 = new Scanner(System.in);
        String note = scanner3.next();
        System.out.println("请输入消费金额：");
        double money3 = scanner3.nextDouble();
        if (money3 <= 0 || money3 > money.getMoney()) {
            System.out.println("消费金额需要在0-" + money.getMoney());
            return;
        }
        this.minusMoney(money, money3);
        String behavior2 = note + " -" + money3;
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format2 = LocalDateTime.now().format(df2);
        String moneyDetail2 = "余额:" + money.getMoney();
        SmallChanageDetail smallChanageDetail2 = new SmallChanageDetail(behavior2, format2, moneyDetail2);
        smallChanageDetailList.add(smallChanageDetail2);
    }

    public void exit() {
        System.out.println("退出零钱通");
    }

    public void printDetail(List<SmallChanageDetail> smallChanageDetails) {
        System.out.println("----------零钱通明细-----------");
        for (int i = smallChanageDetails.size() - 1; i >= 0; i--) {
            System.out.println(smallChanageDetails.get(i).getBehaviour() + "\t" + smallChanageDetails.get(i).getTime()
                    + "\t" + smallChanageDetails.get(i).getMoneyDetail());
        }
    }

    public void plusMoney(Money money, double moneyGeted) {
        money.setMoney(money.getMoney() + moneyGeted);
    }

    public void minusMoney(Money money, double moneyUsed) {
        money.setMoney(money.getMoney() - moneyUsed);
    }
}

class Money {
    double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

class SmallChanageDetail {

    private String behaviour;
    private String time;
    private String moneyDetail;

    public SmallChanageDetail(String behaviour, String time, String moneyDetail) {
        this.behaviour = behaviour;
        this.time = time;
        this.moneyDetail = moneyDetail;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoneyDetail() {
        return moneyDetail;
    }

    public void setMoneyDetail(String moneyDetail) {
        this.moneyDetail = moneyDetail;
    }
}

