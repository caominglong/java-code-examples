package com.banmao.advanced_grammar.design_pattern.template_design;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/30 上午10:53
 * @description 模版方法设计模式
 * 设计思想：将任务的主逻辑方法交由父类定义，父类定义普通方法与抽象方法，抽象方法就是子类中发生变化的部分。
 * 每个子类重写此抽象方法，实现自己的逻辑。
 */
public abstract class Template {

    /**
     * 执行任务的逻辑
     */
    public abstract void job();

    public void calculateTime() {
        // 统计当前时间距离1970-1-1 0:0:0的时间差，单位ms
        long start = System.currentTimeMillis();
        // 模版方法的体现
        job();
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间为：" + (end - start));
    }
}

class BBB extends Template {
    @Override
    public void job() {
        long num = 0;
        for (int i = 1; i <= 80000; i++) {
            num *= i;
        }
    }
}

class AAA extends Template{


    @Override
    public void job() {
        long num = 0;
        for (int i = 1; i <= 100000; i++) {
            num += i;
        }
    }
}
