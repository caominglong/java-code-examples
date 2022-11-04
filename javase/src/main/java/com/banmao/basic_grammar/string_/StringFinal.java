package com.banmao.basic_grammar.string_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/1 下午9:16
 * @description
 */
public class StringFinal {

    public static void main(String[] args) {
        // String是常量类，理解常量机制
        // 实例1，引用是可变的，对象不可变
        String aa = "1111";
        aa = "3333";
        System.out.println(aa);

        // 实例2，演示对象不可变
        String bb = new String("1111");

        bb = aa;
        System.out.println(bb);


        final int[] intArr = new int[]{1,2};
        int[] intArr2 = new int[]{2,3};
        // intArr = intArr2;

        StrFinal strFinal = new StrFinal("111");
        StrFinal strFinal2 = new StrFinal("222");
        strFinal = strFinal2;

        System.out.println(strFinal);

        final Integer[] integers = new Integer[]{1,2};
        Integer[] integers2 = new Integer[]{2,3};
        // integers = integers2;

//        final String aaa = "aaa";
//        String bbb = "vvvv";
//        aaa = bbb;
        // 总结：final修饰
        // 1、修饰基本类型、值不可变
        // 2、修饰引用数据类型，引用地址不可变。但对象的值是可变的

        // 总结：String
        // String类本身用final修饰，所以该类不可被继承
        // String对象不可变的关键在于，其中的字符数组是被final修饰的，比如final char values[]
        // 而且是私有的。但是通过反射还是可以暴力破解。
    }
}

final class StrFinal {
    private String name;

    public StrFinal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StrFinal{" +
                "name='" + name + '\'' +
                '}';
    }
}