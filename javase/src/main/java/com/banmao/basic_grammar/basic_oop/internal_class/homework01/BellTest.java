package com.banmao.basic_grammar.basic_oop.internal_class.homework01;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午3:35
 * @description
 */
public class BellTest {

    public static void main(String[] args) {

        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了！");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了！");
            }
        });
    }
}