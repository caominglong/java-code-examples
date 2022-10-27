package com.banmao.basic_grammar.functions;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/20 下午10:06
 * @description
 */
public class MethodParameters {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // 创建AA对象
        AA obj = new AA();
        obj.swap(a, b);
        System.out.println("a=" + a + " b=" + b);
    }

}

class AA {

    public void swap(int a, int b) {
        System.out.println("\na和b交换前的值\na=" + a + "\tb=" + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("\na和b交换后的值\na=" + a + "\tb=" + b);
    }
}