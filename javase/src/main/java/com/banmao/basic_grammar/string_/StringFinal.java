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