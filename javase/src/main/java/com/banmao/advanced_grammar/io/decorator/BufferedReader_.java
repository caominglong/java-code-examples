package com.banmao.advanced_grammar.io.decorator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/12/3 下午2:46
 * @description
 */
public class BufferedReader_ extends Reader_ {

    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    @Override
    public void read() {
        // 使用对象的运行类型来执行真正的请求
        reader_.read();
    }

    /**
     * 还可以增加更加强大的功能，但核心还是使用被包装类的方法
     */
    public void readMoreFile(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("批量读文件");
            reader_.read();
        }
    }
}