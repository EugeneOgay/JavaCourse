package main.java.lessons.lesson3;

public class BankAccount {
    String fio;
    long accountNumber;
    int balance;

    public BankAccount(String fio, long accountNumber, int balance) {
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void Deposit(int amount) {
        balance = balance + amount;
    }

    public void Withdraw(int amount) {
        if(balance > amount) balance = balance - amount;
        else System.out.println("Недостаточно средств на счете");
    }

    public void GetBalance() {
        System.out.printf("У пользователя %s на %d счету - %d UZS\n", fio, accountNumber, balance);
    }
    //Метод: deposit(), withdraw(), getBalance()

}
