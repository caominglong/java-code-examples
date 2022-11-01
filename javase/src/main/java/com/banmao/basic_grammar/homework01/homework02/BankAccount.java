package com.banmao.basic_grammar.homework01.homework02;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/27 下午9:42
 * @description 银行账户
 */
public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 存款
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}