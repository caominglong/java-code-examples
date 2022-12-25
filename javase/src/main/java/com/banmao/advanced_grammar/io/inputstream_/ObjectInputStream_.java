package com.banmao.advanced_grammar.io.inputstream_;

import com.banmao.advanced_grammar.io.outputstream_.Dog;
import org.junit.Test;

import java.io.*;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午5:27
 * @description
 */
public class ObjectInputStream_ {

    @Test
    public void serializableObjectReverse() throws IOException, ClassNotFoundException {
        // 序列化后，保存的文件不是纯文本的，而是按照它的格式来保存
        String filePath = "/Users/cao/Desktop/mulu/data.bat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取的顺序，必须与序列化的顺序一致

        int i = ois.readInt();
        System.out.println(i);
        boolean b = ois.readBoolean();
        System.out.println(b);
        char c = ois.readChar();
        System.out.println(c);
        double v = ois.readDouble();
        System.out.println(v);
        String s = ois.readUTF();
        System.out.println(s);
        Object object = ois.readObject();
        System.out.println(object.getClass());
        System.out.println("Dog的信息：" + object);

        // 向下转型
        Dog dog = (Dog) object;
        System.out.println("狗的名字：" + dog.getName());
        ois.close();

        System.out.println("数据保存完毕！");

    }
}