package com.banmao.basic_grammar.homework01.homework02;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/27 下午9:45
 * @description
 */
public class CheckingAccount extends BankAccount{


    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        // 1美元手续费
        setBalance(getBalance() - 1);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        // 1美元手续费
        setBalance(getBalance() - 1);
    }
}