package com.banmao.advanced_grammar.java8.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/25 下午10:00
 * @description Stream的中间操作
 */
public class StreamApiTest02 {


    /**
     * 1-筛选与切片
     */
    @Test
    public void createStream01() {
        List<String> stringList = Arrays.asList("成龙", "李小龙", "中国龙", "森蚺");
        List<String> longList = stringList.stream().filter(str -> str.contains("龙")).collect(Collectors.toList());
        System.out.println(longList);
    }

    /**
     * 创建Stream方式2：通过数组
     */
    @Test
    public void createStream02() {
        int[] ints = {1,2,4};
        IntStream stream = Arrays.stream(ints);

    }

    /**
     * 创建Stream方式3：通过Stream类中的of()方法
     */
    @Test
    public void createStream03() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    /**
     * 创建Stream方式4：创建无限流1
     */
    @Test
    public void createStream04() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

    }

    /**
     * 创建Stream方式5：创建无限流2
     */
    @Test
    public void createStream05() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}