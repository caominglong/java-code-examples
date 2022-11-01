package com.banmao.advanced_grammar.design_pattern.template_design;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 上午11:02
 * @description
 */
public class TemplatePattern {

    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime();

        BB bb = new BB();
        bb.calculateTime();
    }
}