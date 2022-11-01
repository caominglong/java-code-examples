package com.banmao.advanced_grammar.design_pattern.template_design;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 上午11:00
 * @description
 */
public class BB extends Template {
    @Override
    public void job() {
        long num = 0;
        for (int i = 1; i <= 80000; i++) {
            num *= i;
        }
    }
}