package com.banmao.basic_grammar.date_;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: jdk1.0的Date日期时间类
 * @author: banmao
 * @date: 2022/11/3 15:34
 */
public class Date_ {

    public static void main(String[] args) {

        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        // 创建一个日期
        // 构造方法1：无参构造函数
        Date date = new Date();
        String format2 = sdf.format(date);
        System.out.println("date格式化1之后：" + format2);

        // 构造方法2：传毫秒值的构造函数
        long millisecond = 34333334455L;
        Date date2 = new Date(millisecond);
        System.out.println(date2.toString());

        // 常用方法
        long time = date.getTime();
        System.out.println("time：" + time);
        Date date3 = date;
        int compareInt = date.compareTo(date3);
        System.out.println("compareInt：" + compareInt);

        // setTime可改变date对象内部状态，修改时间
        date.setTime(1667524242560L);

        String format = sdf.format(date);
        System.out.println("date格式化2之后：" + format);

        Instant instant = date.toInstant();
        System.out.println("instant：" + instant);
    }
}
