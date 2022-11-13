package com.banmao.basic_grammar.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/11/6 上午10:15
 * @description 循环下的递归
 */
public class RecursionFor2 {

    public static void main(String[] args) {

//        for (int i = 0; i < 10; i++) {
//            if (i > 5) {
//                return;
//            }
//            System.out.println(i);
//        }

        RecursionFor2 recursionFor2 = new RecursionFor2();
        Map<String, List<Point>> map = recursionFor2.buildUndigraph();
        boolean direction = recursionFor2.direction2(map, new ArrayList<>(), new Point("00000", "aaa"), new Point("99999", "aaaa"));
        System.out.println("退出查找后的结果：" + direction);
    }


    /**
     * 递归寻找方向
     * @param map
     * @param startPoint 从哪个点开始寻找
     * @param findPoint 要找哪个点
     */
    public boolean direction(Map<String, List<Point>> map, List<String> visitedPoint, Point startPoint, Point findPoint) {

        System.out.println("startPoint的值为：" + startPoint.getId());
        visitedPoint.add(startPoint.getId());
        if (startPoint.getId().equals("55555")) {
            System.out.println("ssssss");
        }

        if (findPoint.getId().equals(startPoint.getId())) {
            System.out.println("找到了findPoint");
            return true;
        }
        if (map.containsKey(startPoint.getId())) {
            List<Point> points = map.get(startPoint.getId());
            for (Point point : points) {



                if (findPoint.getId().equals(point.getId())) {
                    System.out.println("找到了findPoint2222");
                    return true;
                }
                direction(map, visitedPoint, point, findPoint);
            }
        }
        return false;
    }

    /**
     * 递归寻找方向
     * @param map
     * @param startPoint 从哪个点开始寻找
     * @param findPoint 要找哪个点
     */
    public boolean direction2(Map<String, List<Point>> map, List<String> visitedPoint, Point startPoint, Point findPoint) {

        System.out.println("startPoint的值为：" + startPoint.getId());
        visitedPoint.add(startPoint.getId());

        if (findPoint.getId().equals(startPoint.getId())) {
            System.out.println("找到了findPoint");
            return true;
        }
        if (map.containsKey(startPoint.getId())) {
            List<Point> points = map.get(startPoint.getId());
            for (Point point : points) {
                if (visitedPoint.contains(point.getId())) {
                    return false;
                }

                boolean b = direction2(map, visitedPoint, point, findPoint);
                System.out.println("b=" + b);
                if (b) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * "00000"等于要分析的结点id，且只有两个结点是它的邻接结点
     * @return
     */
    private Map<String, List<Point>> buildUndigraph() {
        // 以下其实构建的是一个树形结构
        Map<String, List<Point>> undiGraph = new HashMap<>();

        Point point1 = new Point("11111", "point1");
        Point point2 = new Point("22222", "point2");
        Point point3 = new Point("33333", "point3");
        Point point4 = new Point("44444", "point4");
        Point point5 = new Point("55555", "point5");
        Point point6 = new Point("66666", "point6");
        Point point7 = new Point("77777", "point7");
        Point point8 = new Point("88888", "point8");
        Point point9 = new Point("99999", "point9");
        Point point10 = new Point("1010101010", "point10");
        List<Point> adjPoint = new ArrayList<>();
        adjPoint.add(point1);
        adjPoint.add(point2);
        undiGraph.put("00000", adjPoint);

        // 构建point1的邻接结点
        List<Point> adjPoint2 = new ArrayList<>();
        adjPoint2.add(point3);
        adjPoint2.add(point4);
        adjPoint2.add(new Point("00000", "aaa"));
        undiGraph.put("11111", adjPoint2);

        // 构建point2的邻接结点
        List<Point> adjPoint3 = new ArrayList<>();
        adjPoint3.add(point5);
        adjPoint3.add(point6);
        adjPoint3.add(new Point("00000", "aaa"));
        undiGraph.put("22222", adjPoint3);

        // 构建point3的邻接结点
        List<Point> adjPoint4 = new ArrayList<>();
        adjPoint4.add(point7);
        adjPoint4.add(point1);
        undiGraph.put("33333", adjPoint4);

        // 构建point4的邻接结点
        List<Point> adjPoint5 = new ArrayList<>();
        adjPoint5.add(point8);
        adjPoint5.add(point1);
        undiGraph.put("44444", adjPoint5);

        // 构建point5的邻接结点
        List<Point> adjPoint6 = new ArrayList<>();
        adjPoint6.add(point9);
        adjPoint6.add(point10);
        adjPoint6.add(point2);
        undiGraph.put("55555", adjPoint6);

        return undiGraph;
    }
}


class Point {
    String id;
    String name;

    public Point(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}