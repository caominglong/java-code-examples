package com.banmao.basic_grammar.functions;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: 方法参数理解
 * @author: banmao
 * @date: 2022/11/4 20:26
 */
public class MethodParam {

    public static void main(String[] args) {
        MethodParam methodParam = new MethodParam();
        int int1 = 10;
        methodParam.modifyValue(int1);
        System.out.println("int1：" + int1);

        Boolean flag = false;
        methodParam.modifyValue2(flag);
        System.out.println("flag：" + flag);

        Boolean flag2 = new Boolean(false);
        methodParam.modifyValue2(flag2);
        System.out.println("flag2：" + flag2);
    }

    /**
     * 基本类型变量是值拷贝，方法内修改的值不会影响方法外
     * @param aaa
     */
    public void modifyValue(int aaa) {
        aaa = 1000;
    }

    /**
     * 如果是基本类型的包装类，拷贝的是引用的地址
     * 相当于flag与外面的flag2都是指向new Boolean(false)对象
     * 所以当你在flag = new Boolean(true);时，只是将flag2的引用
     * 地址改为了一个新的Boolean对象而已
     * @param flag
     */
    public void modifyValue2(Boolean flag) {
        flag = new Boolean(true);
    }
}
