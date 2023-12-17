package com.banmao.advanced_grammar.design_pattern.decorator;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2023/3/31 下午9:51
 * @description 吃
 */
public interface Eat {

    void eat();
}

// 吃米饭
class EatRice implements Eat {
    @Override
    public void eat() {

    }


}

class EatRiceDecorator implements Eat {

    private Eat eat;

    public EatRiceDecorator(Eat eat) {
        this.eat = eat;
    }

    @Override
    public void eat() {
        prepareBowlAndChopsticks();
        // 开始吃饭
        eat.eat();
    }

    // 准备碗筷
    private void prepareBowlAndChopsticks() {
        System.out.println("吃饭前准备好碗筷");
    }
}