package com.banmao.network.nio_;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/2/12 下午2:40
 * @description nio的字符集
 */
public class CharsetTest {

    @Test
    public void testCharset() {
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        entries.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    }

    @Test
    public void testEncode() throws CharacterCodingException {
        // 编码
        Charset cs1 = Charset.forName("GBK");

        // 获取编码器
        CharsetEncoder charsetEncoder = cs1.newEncoder();

        // 获取解码器
        CharsetDecoder charsetDecoder = cs1.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);

        charBuffer.put("尚硅谷牛逼！");

        charBuffer.flip();

        // 编码
        ByteBuffer encode = charsetEncoder.encode(charBuffer);

        for (int i = 0; i < encode.capacity(); i++) {
            System.out.println(encode.get());
        }

        // 解码
        encode.flip();
        CharBuffer decode = charsetDecoder.decode(encode);
        System.out.println(decode.toString());
    }
}