package com.banmao.basic_grammar.homework01.homework02;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/27 下午9:48
 * @description
 */
public class SavingAccount extends CheckingAccount {

    // 利率
    private double interestRate;

    private int size;

    public SavingAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }

    public void earnMonthlyInterest() {
        setBalance(getBalance() + getBalance() * interestRate);
        size = 0;
    }

    @Override
    public void deposit(double amount) {
        size++;
        if (size > 3) {
            super.deposit(amount);
        } else {
            setBalance(getBalance() + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        size++;
        if (size > 3) {
            super.withdraw(amount);
        } else {
            setBalance(getBalance() + amount);
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}