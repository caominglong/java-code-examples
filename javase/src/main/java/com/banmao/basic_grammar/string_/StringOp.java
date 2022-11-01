package com.banmao.basic_grammar.string_;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/9/4 下午12:51
 * @description 对于JavaSE的字符串的相关操作类
 */
public class StringOp {

    /**
     *
     * @param str 传入的字符串
     */
    public void  printEachChar(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            System.out.println(str.charAt(i));
        }
    }

    /**
     *
     * @param chars 传入的字符数组
     */
    public void  printEachChar(char[] chars) {
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            System.out.println(chars[i]);
        }
    }

    public void replaceStr(String originStr, String oldStr, String newStr) {
        String replace = originStr.replace(oldStr, newStr);
        System.out.println(replace);
    }

    // 格式化输出
    public void formatOut() {
        double x = 10000.0 / 3.0;
        System.out.println(x);
        System.out.printf("%8.2f", x);
        String name = "草明龙";
        int age = 26;
        System.out.printf("Hello,%s.Next year,you,ll be %d", name, age);

        System.out.println();
        // 在Java中，所有整型字面值都是int型，所有小数都是double型。
        // 在Java中两个变量只要参与了数学运算，就有可能会进行类型提升，只要类型比int小(即byte,char,short)，那么在运算之前，这些值会自动转换成int。
        // 校验值也分为很多算法，常见的有求和与异或校验
        // 但是在Java中有一点需要特别注意，除了boolean和char是无符号的，其余的基本数据类型都是有符号的。而符号要怎么表示的，答案就是用最高位来标识，0为正数，1为负数。
        // 计算机用补码的方式存储数值，正数的补码是自身，而负数的补码则是其绝对值按位取反再加1。
        // 什么情况下byte的赋值会报错提示类型不对呢？那就是当数值大于127，换句话说就是byte的最高位为1时，在16进制里面就是当第1位大于7时就会报错。
        // 称位操作在Java中有3种，
        //左移<<,低位补零
        // 右移>>,若符号为正则在高位插入0，符号为负则在高位插入1
        // 无符号右移>>>,无论正负，都在高位插入0
        byte by = 0b00000001;
        System.out.printf("hex is：%x", by);

        //printf标志
        // 格式说明符按以下顺序包括标志、宽度、精度和转换字符:
        // %[flags][width][.precision]conversion-character
        // 10代表用10个字符的宽度，和小数点后保留两位的精度打印
        System.out.println();
        System.out.printf("%10.2f", 10000.0/3.0);
        // ,表示分组，
        System.out.println();
        System.out.printf("%,.2f", 10000.0/3.0);
        // ,表示分组，
        System.out.println();
        System.out.printf("%,10.2f", 10000.0/3.0);

        // printf转换字符
        // 换行【%n】
        System.out.println();
        System.out.printf("hello%ncaominglong");
        // 打印字符串【%s】
        System.out.println();
        System.out.printf("hah%s", "goos");
        // 打印十进制整数【%d】
        System.out.println();
        System.out.printf("hah%d", 1111);
        // 打印十进制整数%d，并进行格式化,规定8个字符的宽度，不够的位置补充0
        System.out.printf("%08d", 1111);
        // 标志【+】 打印正数与负数的符号
        System.out.printf("%n%+d", 1111);
        // 标志【空格】，在正数之前添加空格
        System.out.printf("%n% d", 1111);
        // 标志【-】，左对齐，必须结合宽度使用
        System.out.printf("%n%-8d", 1111);
        // 标志【（】，将负数括在括号里
        System.out.printf("%n%(d", -1111);
        // 标志【,】，添加分组分隔符,按每三个进行分组
        System.out.printf("%n%,d", 122222);
        // 标志【#】，包含小数点,对于定点浮点数可用
        System.out.printf("%n%#4.0f", 12f);
        // 标志【#】，添加前缀0x和0，适用于x与o格式
        byte e = 0b00000011;
        System.out.printf("%n%#04x", e);
        // 标志【$】，给定被格式化的参数索引，如下：第一个参数用十六进制打印，第二个参数用十进制整数打印
        System.out.printf("%n%1$x, 哈哈，%2$d", 12, 100);
        // 标志【<】，格式化前面说明的数值，相当于参数复用
        System.out.printf("%n%1$x, 哈哈，%<d", 12);

    }

    public static void main(String[] args) {
        StringOp stringOp = new StringOp();
//        // 1
//        stringOp.printEachChar(new char[]{'a', 'b', 'c', 'k'});
//
//        // 2
//        stringOp.printEachChar("abck");
//
//        // 3、替换字符串中的某个子串
//        stringOp.replaceStr("abcdef", "abc", "ghi");

        // 4、格式化输出
        stringOp.formatOut();
    }
}