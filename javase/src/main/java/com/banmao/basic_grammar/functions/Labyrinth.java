package com.banmao.basic_grammar.functions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/21 下午10:15
 * @description 迷宫
 */
public class Labyrinth {

    public static void main(String[] args) {

        TT t = new TT();
        // 用二维数组创建迷宫,8行7列
        int[][] map = new int[8][7];
        // 先固定map数组中，0代表没有障碍物。1代表是障碍物
        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if (j == 0 || j == map[i].length - 1) {
                    map[i][j] = 1;
                }
            }

            if (i == 0 || i == map.length - 1) {
                // 遍历列
                for(int j = 0; j < map[i].length; j++) {
                    map[i][j] = 1;
                }
            }
        }
        map[3][1] = 1;
        map[3][2] = 1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println("");
        }

        List<Path> list = new ArrayList<>();
        List<Path> labyrinth = t.labyrinth(list, map, 1, 1);
        System.out.println(labyrinth);
    }
}

class TT {

    // 递归调用，迷宫问题
    public List<Path> labyrinth(List<Path> list, int[][] map, int i, int j) {

        // 思路分析
        // map[1][1]为起点。
        // 先向右一直找，直到遇到墙壁。然后开始向下找
        // 结束标记是什么？当到达map[6][5]的时候，迷宫结束
        // 确定找路的策略
        if (i >= 6 && j >= 5) {
            Path path = new Path();
            path.setX(i);
            path.setY(j);
            list.add(path);
            return list;
        } else {
            if (map[i][j] == 0) {
                Path path = new Path();
                path.setX(i);
                path.setY(j);
                list.add(path);
                return labyrinth(list, map, i + 1, j);
            } else if (map[i][j] == 1){
                return labyrinth(list, map, i - 1, j + 1);
            } else{
                return null;
            }
        }
    }

    // 递归调用，迷宫问题优化

    public boolean findway(int[][] map, int i, int j) {

        // 思路分析
        // 定义map数组中各个值的含义：
        // 0-表示可以走 1-表示障碍物 2-表示可以走 3-表示走过，但是走不通是死路
        // 确定老鼠走路策略：下 -> 右  -> 上 -> 左
        if (map[6][5] == 2) { // 说明已经找到
            return true;
        } else {
            if (map[i][j] == 0) { // 当前这个位置为0，表示可以走
                // 可以走通,将当前位置的状态设置为2
                map[i][j] = 2;
                // 开始找路，往下一个方向走
                if (findway(map, i + 1, j)) {// 往下走
                    return true;
                } else if (findway(map, i, j + 1)) { // 走右
                    return true;
                } else if (findway(map, i - 1, j)) { // 走上
                    return true;
                } else if (findway(map, i, j - 1)) { // 走左
                    return true;
                } else {
                    // 四个位置都不能走通。将状态设置为3
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}



class Path {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}