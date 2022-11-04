package com.banmao.basic_grammar.string_;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: 字符串反转
 * @author: banmao
 * @date: 2022/11/3 15:10
 */
public class StringReverse {

    /**
     * 反转字符串，反转范围为[start, end]
     *
     * @param str   要被反转的字符串
     * @param start 从当前字符串的start位置开始反转
     * @param end   反转到当前字符串的end位置
     * @return char[] 返回反转后的字符数组
     */
    public char[] reverse(String str, int start, int end) throws Exception {

        // 进行数据验证，提高代码健壮性
        if (!(str != null && start < end && end < str.length() - 1)) {
            throw new Exception();
        }

        char[] chars = str.toCharArray();
        // 思路分析：
        // 建立两个游标，一个从左往右，一个从右往左，当游标碰头时，证明反转工作结束
        for (int i = start, j = end; i < j; i++, j--) {
            // 替换两个字符的位置
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return chars;
    }

    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        String str = "abcdef";
        char[] reverse = new char[0];
        try {
            reverse = stringReverse.reverse(str, 0, 3);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("输入的数据格式不正确！");
            return;
        }
        System.out.println(new String(reverse));
    }
}
