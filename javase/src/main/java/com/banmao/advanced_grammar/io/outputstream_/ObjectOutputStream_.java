package com.banmao.advanced_grammar.io.outputstream_;

import org.junit.Test;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午5:02
 * @description 演示完成对象的序列化
 */
public class ObjectOutputStream_ {

    @Test
    public void serializableObject() throws IOException {
        // 序列化后，保存的文件不是纯文本的，而是按照它的格式来保存
        String filePath = "/Users/cao/Desktop/mulu/data.bat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        oos.writeInt(100);
        oos.writeBoolean(true);
        oos.writeChar('A');
        oos.writeDouble(9.5);
        oos.writeUTF("曹明龙");
        oos.writeObject(new Dog("旺财", 10, "黑色"));

        oos.close();

        System.out.println("数据保存完毕！");
    }
}

