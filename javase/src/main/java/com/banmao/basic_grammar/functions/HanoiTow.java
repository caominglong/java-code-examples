package com.banmao.basic_grammar.functions;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/22 上午7:39
 * @description 汉诺塔问题，移动圆盘
 */
public class HanoiTow {

    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(3, 'a', 'b', 'c');
    }
}

class Tower {
    // num表示a中盘子的数量
    // a,b,c分别表示a塔、b塔、c塔
    // 思路分析
    // 当存在多个盘时，可以看作两个盘，最下面的和上面的所有盘，
    //
    // 然后问题就简化为：将b中的两（num - 1）个盘，移动到a
    // 结束条件：当num只有一个盘的时候，从a -> c就结束
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + " --> " + c);
        } else {
            // 当存在多个盘时，可以看成两个盘
            //（1）移动上面的所有盘到b，借助c
            // 关键思想在于，此数的递归调用，是将问题一步步往下简化，直到num=1。
            // 然后当move(num - 1, a, c, b);的调用返回了，也就是将所有盘移动到c了。
            // 这时候，再去执行剩下的步骤
            move(num - 1, a, c, b);
            // (2) 将下面的盘，移动到c
            System.out.println(a + " --> " + c);
            // (3) 再把b的所有盘，移动到c，借助a
            move(num - 1,b, a, c);
        }
    }
}