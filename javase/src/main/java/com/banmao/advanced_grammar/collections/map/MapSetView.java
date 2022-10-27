package com.banmao.advanced_grammar.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Company: 杭州领图信息科技有限公司
 *
 * @description: map通过keyset返回的是一个set视图
 * 对于同一个map对象，多次调用keyset返回的是同一个set视图。
 * 当其中一个返回对象发生变化时，所有其他的返回对象也要发生变化
 * @author: banmao
 * @date: 2022/10/27 14:38
 */
public class MapSetView {

    public static void main(String[] args) {
        Map<String, String> mapSetView = new HashMap<>();
        mapSetView.put("name", "曹明龙");
        mapSetView.put("age", "27");
        mapSetView.put("weight", "120");
        Set<String> setView1 = mapSetView.keySet();

        for (String key : setView1) {
            System.out.println(key);
        }

        Set<String> setView2 = mapSetView.keySet();
        // 1、当进行setView2添加key的时候，遍历数据的时候将会报出
        // java.lang.UnsupportedOperationException异常
        // setView2.add("height");
        // 2、当给map添加了一个元素后，下面的set视图：setView1,setView2
        // 都将反应出改变。
        mapSetView.put("height", "180");

        System.out.println("================setView2=================");
        for (String key : setView2) {
            System.out.print(key + "\t");
        }

        System.out.println("\n================setView1=================");
        for (String key : setView1) {
            System.out.print(key + "\t");
        }
    }
}
