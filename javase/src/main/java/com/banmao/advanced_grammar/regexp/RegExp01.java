package com.banmao.advanced_grammar.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/24 下午8:53
 * @description 正则表达式第一个案例
 */
public class RegExp01 {

    public static void main(String[] args) {
        String content = "1998年12月8日，第二代Java平台的企业版J2EE发布。1999年6月，" +
                "Sun公司发布了第二代Java平台（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Java2平台的微型版），" +
                "应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2平台的标准版），" +
                "应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2平台的企业版），" +
                "应用于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重要的一个里程碑，标志着Java的应用开始普及。";

        // 1、匹配所有数字
        // \\d表示任意一个数字
        String regStr = "\\d\\d\\d\\d";
        // 2、创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        // 3、创建匹配器
        // 说明：创建匹配器matcher，按照正则表达式的规则 去匹配content字符串
        Matcher matcher = pattern.matcher(content);

        // 4、开始匹配
        // 1、根据指定的规则，定位满足规则的子字符串(比如1998)，
        // 2、找到后，将子字符串的开始位置的索引记录到matcher对象的属性 int[] groups
        // groups[0] = 0,把该子字符串的结束索引+1存储到groups[1]的位置，groups[1] = 4
        // 3、同时记录oldLast的值为子字符串的结束的索引+1的值即4，即下次执行时就从oldLast开始匹配
        
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}