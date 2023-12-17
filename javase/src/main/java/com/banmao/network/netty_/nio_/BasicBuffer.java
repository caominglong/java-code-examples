package com.banmao.network.netty_.nio_;

import java.nio.IntBuffer;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/14 下午10:08
 * @description
 */
public class BasicBuffer {

    // 举例说明buffer的使用
    public static void main(String[] args) {
        // 创建一个buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 向buffer中存放数据
        intBuffer.put(10);
        intBuffer.put(11);
        intBuffer.put(12);
        intBuffer.put(13);
        intBuffer.put(14);

        // 读写切换
        intBuffer.flip();

        System.out.println(intBuffer.get(2));
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());
    }
}