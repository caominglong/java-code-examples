package com.banmao.network.nio_;

import java.nio.ByteBuffer;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/11 下午6:37
 * @description
 */
public class ByteBufferUtil {

    public static void printByteBufferProperties(ByteBuffer byteBuffer) {
        System.out.println("=========execute print=========");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
    }
}