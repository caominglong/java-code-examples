package com.banmao.basic_grammar.enumeration;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午4:51
 * @description 演示Enum常用方法
 */
public class EnumMethod {

    public static void main(String[] args) {
        // name方法
        Season2 autumn = Season2.AUTUMN;
        String name = autumn.name();
        // 输出枚举对象的名字
        System.out.println("name=" + name);

        // ordinal方法
        int ordinal = autumn.ordinal();
        // 输出该常量对象的次序（编号），常量对象从0开始编号
        System.out.println("ordinal=" + ordinal);

        // values方法，返回所有的枚举对象组成的数组
        Season2[] values = Season2.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println("枚举对象为：" + values[i]);
        }

        // valueOf(）。将字符串转换成枚举对象
        // 必须为已有的常量名（名称不能瞎写），否则抛异常
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println("autumn1：" + autumn1);

        // compareTo，比较两个枚举常量，比较的是编号
        System.out.println(autumn.compareTo(autumn1));
    }
}