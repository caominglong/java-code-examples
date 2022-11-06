package com.banmao.basic_grammar.functions;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: for循环下的递归
 * @author: banmao
 * @date: 2022/11/4 20:45
 */
public class RecursionFor {

    public static void main(String[] args) {
        RecursionFor recursionFor = new RecursionFor();
        recursionFor.doFor(0);
    }

    /**
     * 这个程序用于都停止不了，因为i的值一直在递增，且递增速度比j快
     * @param i
     */
    public void doFor(int i) {
        if (i >= 3) {
            System.out.println("i=" + i);
            return;
        }
        for (int j = 0; j < 2; j++) {
            doFor(++i);
        }
    }
}
