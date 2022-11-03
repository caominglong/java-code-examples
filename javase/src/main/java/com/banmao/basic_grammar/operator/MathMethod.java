package com.banmao.basic_grammar.operator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/3 下午8:41
 * @description Math相关的方法
 */
public class MathMethod {

    public static void main(String[] args) {

        // 1、取绝对值
        int abs = Math.abs(-1);
        System.out.println("abs：" + abs);
        int abs2 = Math.abs(5);
        System.out.println("abs2：" + abs2);

        // 向上取整,返回大于当前数的最小整数（转成double）
        double ceil = Math.ceil(1.56);
        System.out.println("ceil：" + ceil);

        // 向下取整，返回小于当前数的最大整数（转成double）
        double floor = Math.floor(-5.1);
        System.out.println("floor：" + floor);

        // 四舍五入
        long round = Math.round(5.0045);
        System.out.println("round：" + round);

        // 开方
        double sqrt = Math.sqrt(9.0);
        System.out.println("sqrt：" + sqrt);

        // 返回0-1之间的随机小数，此数  0 <= x < 1
        double random = Math.random();
        for (int i = 0; i < 10; i++) {
            // System.out.println(Math.random());
        }

        // 要求返回一个数，此数  2<= x <=7
        for (int i = 0; i < 10000; i++) {
            int equals2 = (int) (2 + Math.random() * 6);
            if (equals2 < 2 || equals2 > 7) {
                System.out.println(equals2);
            }
        }

        int min = Math.min(100, 10);
        System.out.println("min：" + min);

        int max = Math.max(100, 10);
        System.out.println("max：" + max);

        // 求平方
        double pow = Math.pow(2, 4);
        System.out.println("pow：" + pow);
    }
}