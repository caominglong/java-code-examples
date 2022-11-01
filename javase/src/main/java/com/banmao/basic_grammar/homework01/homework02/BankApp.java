package com.banmao.basic_grammar.homework01.homework02;

/**
 * @author banmao
 * @version V1.0.0
 * @date 2022/10/27 下午9:59
 * @description
 */
public class BankApp {

    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount(1000, 0.01);
        savingAccount.deposit(100);
        System.out.println("存钱100，余额为：" + savingAccount.getBalance());
        savingAccount.withdraw(50);
        System.out.println("取钱50，余额为：" + savingAccount.getBalance());
        savingAccount.deposit(200);
        System.out.println("存钱200，余额为：" + savingAccount.getBalance());
        savingAccount.deposit(500);
        System.out.println("存钱500，余额为：" + savingAccount.getBalance());
        savingAccount.earnMonthlyInterest();
        System.out.println("计算利息后，余额为：" + savingAccount.getBalance());
        savingAccount.withdraw(110);
        System.out.println("取钱110，余额为：" + savingAccount.getBalance());
    }
}