package com.banmao.advanced_grammar.io.decorator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午2:46
 * @description
 */
public class FileReader_ extends Reader_{
    @Override
    public void read() {
        System.out.println("写文件");
    }
}