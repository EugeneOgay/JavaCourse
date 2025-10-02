package main.java.lessons.lesson3;

import java.util.ArrayList;

public class BankSystem {
    public static ArrayList<Account> accounts = new ArrayList<>();

    public static void AddAccount(Account newAccount) {
        if(accounts.isEmpty()) {
            accounts.add(newAccount);
            return;
        }
        for (Account account : accounts) {
            if(account.accountNumber ==  newAccount.accountNumber && account.fio.equalsIgnoreCase(newAccount.fio)) {
                System.out.printf("Уже есть аккаунт со счетом %d и пользователем %s", account.accountNumber, account. fio);
                return;
            }
        }
        accounts.add(newAccount);
    }

    public static void DeleteAccount(Account accountToDelete) {
        if(accounts.isEmpty()) {
            System.out.println("Отсутсвуют записи об аккаунтах");
            return;
        }
        var foundAcc = accounts.stream().filter(acc  -> acc.accountNumber == accountToDelete.accountNumber).findFirst().orElse(null);
        if(foundAcc != null){
            accounts.remove(foundAcc);
            return;
        }
        System.out.println("Нет подобного аккаунта");
    }

    public static void ReplenishAccount(int accNumber, int amount) {
        if(accounts.isEmpty()) {
            System.out.println("Отсутсвуют записи об аккаунтах");
            return;
        }
        var foundAcc = accounts.stream().filter(acc  -> acc.accountNumber == accNumber).findFirst().orElse(null);
        if(foundAcc != null){
            foundAcc.Replenish(amount);
            return;
        }
        System.out.println("Нет подобного аккаунта");
    }

    public static void GetAccountInfo(int accNumber) {
        if(accounts.isEmpty()) {
            System.out.println("Отсутсвуют записи об аккаунтах");
            return;
        }
        var foundAcc = accounts.stream().filter(acc  -> acc.accountNumber == accNumber).findFirst().orElse(null);
        if(foundAcc != null){
            foundAcc.GetAccountInfo();
        } else System.out.println("Нет подобного аккаунта");
    }

    public static void TransferMoneyBetweenAccounts(int senderAcc, int receiverAcc, int amount) {
        var sender = accounts.stream().filter(acc  -> acc.accountNumber == senderAcc).findFirst().orElse(null);
        var receiver = accounts.stream().filter(acc  -> acc.accountNumber == receiverAcc).findFirst().orElse(null);
        if(sender == null || receiver == null) {
            System.out.println("Неверные данные  аккаунтов");
            return;
        }
        if (amount > sender.balance) {
            System.out.println("Недостаточно средств для перевода");
            return;
        }
        sender.balance = sender.balance - amount;
        receiver.balance =  receiver.balance + amount;
    }

    public static class Account {
        private int accountNumber;
        private String fio;
        private int balance;

        public Account(int accountNumber, String fio, int balance) {
            this.accountNumber = accountNumber;
            this.fio = fio;
            this.balance = balance;
        }

        public void GetAccountInfo() {
            System.out.printf("Номер: %d, ФИО: %s, Баланс: %d\n", accountNumber, fio, balance);
        }

        public void Replenish(int amount) {
            balance = balance + amount;
        }
    }
}
