package com.banmao.basic_grammar.enumeration;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 下午4:18
 * @description 枚举
 */
public class Enumeration01 {

    public static void main(String[] args) {
        // 对于季节来说，对象固定就四个，不会有更多
        // 按目前这个类设计来说，不能体现是固定的四个对象
        // 因此，这样的设计不好，于是需要通过枚举来解决问题
    }

}

class Season {
    private String name;
    private String desc;

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}