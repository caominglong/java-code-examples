package com.banmao.basic_grammar.basic_oop.internal_class.homework08;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/31 下午9:46
 * @description
 */
public class ColorApp {
    public static void main(String[] args) {

        Color black = Color.BLUE;
        black.show();

        switch (black) {
            case RED:
                Color.RED.show();
                break;
            case BLUE:
                Color.BLUE.show();
                break;
            default:
                break;
        }
    }
}