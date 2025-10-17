package main.java.lessons.lesson3;

import java.util.ArrayList;

public class BankSystem {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account newAccount) {
        for (Account account : accounts) {
            if(account.accountNumber == newAccount.accountNumber && account.fio.equalsIgnoreCase(newAccount.fio)) {
                System.out.printf("Уже есть аккаунт со счетом %d и пользователем %s", account.accountNumber, account. fio);
                return;
            }
        }
        accounts.add(newAccount);
    }

    public void deleteAccount(Account accountToDelete) {
        if(isAccountsEmpty()) {
            return;
        }
        var foundAcc = searchAccount(accountToDelete.accountNumber);
        if(foundAcc != null){
            accounts.remove(foundAcc);
            return;
        }
        System.out.println("Нет подобного аккаунта");
    }

    public void replenishAccount(int accNumber, int amount) {
        if(isAccountsEmpty()) {
            return;
        }
        var foundAcc = searchAccount(accNumber);
        if(foundAcc != null){
            foundAcc.replenish(amount);
            return;
        }
        System.out.println("Нет подобного аккаунта");
    }

    public void getAccountInfo(int accNumber) {
        if(isAccountsEmpty()) {
            return;
        }
        var foundAcc = searchAccount(accNumber);
        if(foundAcc != null){
            foundAcc.getAccountInfo();
        } else System.out.println("Нет подобного аккаунта");
    }

    public void transferMoneyBetweenAccounts(int senderAcc, int receiverAcc, int amount) {
        var sender = searchAccount(senderAcc);
        var receiver = searchAccount(receiverAcc);
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

    private Account searchAccount(int accNumber) {
        return accounts.stream().filter(acc -> acc.accountNumber ==  accNumber).findFirst().orElse(null);
    }

    private boolean isAccountsEmpty() {
        if(accounts.isEmpty()) {
            System.out.println("Отсутсвуют записи об аккаунтах");
            return true;
        } else return false;
    }

    public class Account {
        private int accountNumber;
        private String fio;
        private int balance;

        public Account(int accountNumber, String fio, int balance) {
            this.accountNumber = accountNumber;
            this.fio = fio;
            this.balance = balance;
        }

        public void getAccountInfo() {
            System.out.printf("Номер: %d, ФИО: %s, Баланс: %d\n", accountNumber, fio, balance);
        }

        public void replenish(int amount) {
            balance = balance + amount;
        }
    }
}
