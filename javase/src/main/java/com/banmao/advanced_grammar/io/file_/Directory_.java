package com.banmao.advanced_grammar.io.file_;

import java.io.File;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/2 下午9:41
 * @description 目录操作
 */
public class Directory_ {

    public static void main(String[] args) {
        //
        Directory_ directory_ = new Directory_();
        // 这里需要特别注意的是，调用file.delete()方法，如果是目录是不能删除成功的
        // 需要将目录下的文件都删除干净后，才能进行删除目录
        directory_.m1();
//        File file = new File("/Users/cao/Desktop/mulu");
//        directory_.m2(file);
        // directory_.m3();
    }

    // 判断文件是否存在
    public void m1() {
        File file = new File("/Users/cao/Desktop/mulu");
        // 调用相应方法，得到相应的信息
        if (file.exists()) {
            // 存在则删除
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功");
            }
        } else {
            System.out.println("该文件不存在...");
        }
    }

    // 判断目录是否存在
    // 在java中目录也是当作一种文件来处理
    public void m2(File file) {
        // 调用相应方法，得到相应的信息
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File listFile : file.listFiles()) {
                    // 存在则删除

                    m2(listFile);
                }
            }
            file.delete();
        } else {
            System.out.println("该目录不存在...，创建");
            // file.mkdir();
        }
    }

    // 判断目录（/Users/cao/Desktop/mulu/a/b）是否存在，多级目录
    // 在java中目录也是当作一种文件来处理
    public void m3() {
        File file = new File("/Users/cao/Desktop/mulu/a/b");
        // 调用相应方法，得到相应的信息
        if (file.exists()) {
            // 存在则删除
            if (file.delete()) {
                System.out.println(file.getName() + "删除成功");
            }
        } else {
            System.out.println("该目录不存在...，创建");
            file.mkdirs();
        }
    }
}