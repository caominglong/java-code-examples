package com.banmao.advanced_grammar.java8.lambda_;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/25 下午4:14
 * @description
 * 断定型接口（Predicate）的应用
 */
public class Lambda04 {

    public static void main(String[] args) {

    }

    @Test
    public void test1() {

        List<String> list = Arrays.asList("北京","南京","天津","东京","西京", "普京");
        List<String> filterList = filterString(list, str -> str.contains("京"));

        filterList.forEach(str -> System.out.println(str));
    }

    /**
     * 根据指定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
     * @param list
     * @param predicate
     */
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list) {
            if (predicate.test(s)) {
                filterList.add(s);
            }
        }

        return filterList;
    }
}