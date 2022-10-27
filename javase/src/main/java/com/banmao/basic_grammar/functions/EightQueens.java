package com.banmao.basic_grammar.functions;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/22 上午8:15
 * @description
 */
public class EightQueens {

    public static void main(String[] args) {

        Queen queen = new Queen();
        int[] a = new int[8];
        queen.put(a, 0, 0);
    }
}

class Queen {

    /**
     *
     * 思路分析：采用递归的方式
     * 采用递归的原因：
     * 1、有具体的结束标记：当放置最后一个八皇后时，则代表退出
     * 2、每一层的判断逻辑是一致的。比如放置第4个皇后跟放置第6个皇后
     * 判断的逻辑是一致。
     * 先从第一行第一列放置一个皇后，作为程序的开始。a[0]=0
     * 然后进行判断是否放置ok
     *
     * @param a 代表的是八皇后的棋盘
     *          a[0] = 0 => 第1行第1列放置一个皇后
     *          a[1] = 2 => 第2行第3列放置一个皇后
     * @param n 表示当前要放的行
     * @param j 表示当前要放的列
     */
    public void put(int[] a, int n, int j) {
        if (n >= 8) {
            for(int k : a) {
                System.out.print(k + "\t");
            }
            System.out.println();
            return;
        }
        // 关键在于理解，这个for循环，将会随着递归调用的结束，然后继续循环下去。也就是会继续寻找八皇后的正确位置
        for (int i = 0; i < 8; i++) {
            a[n] = i;
            if (examine(a, n)) {
                put(a, n + 1, 0);
            }
        }
    }

    public boolean examine(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 代表在同一列
            // Math.abs(n - i) == Math.abs(array[i] - array[n]) 代表在一条斜线上
            if (a[i] == a[n] || Math.abs(n - i) == Math.abs(a[i] - a[n])) {
                return false;
            }
        }
        return true;
    }


}