//package com.sammidev.datastructure;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class Basic {
//
//    public static void main(String[] args) {
//        Account account = new Account("123456xxx", Bank.BRI);
//        Customer customer = new Customer("Sammidev", "sam@gmail.com");
//
//        List<CreditCard> wallet = Arrays.asList(
//                new CreditCard(customer,account,9000, 960L),
//                new CreditCard(customer,account,9000, 960L)
//
//        );
//
//        Helper helper = new Helper(wallet.get(0));
//        helper.charger(20);
//        helper.charger(50);
//        helper.summary();
//
//        Helper helper2 = new Helper(wallet.get(1));
//        helper2.charger(9000);
//        helper2.summary();
//    }
//}
//
//class CreditCard {
//
//    private Customer customer;
//    private Account account;
//    private int limit;
//    protected double balance;
//
//    public CreditCard(Customer customer, Account account, int limit, double balance) {
//        this.customer = customer;
//        this.account = account;
//        this.limit = limit;
//        this.balance = balance;
//    }
//
//    public CreditCard() {
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public int getLimit() {
//        return limit;
//    }
//
//    public void setLimit(int limit) {
//        this.limit = limit;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//}
//
//class PredatoryCreditCard extends CreditCard {
//
//    private double apr;
//
//    public PredatoryCreditCard(double apr) {
//        this.apr = apr;
//    }
//}
//
//class Helper {
//
//    private CreditCard creditCard;
//    private String status = "SUKSES!";
//
//    public Helper(CreditCard creditCard) {
//        this.creditCard = creditCard;
//    }
//
//    public boolean charger(double price) {
//
//        if (price + creditCard.balance >= creditCard.getLimit()){
//            status = "GAGAL! topup melebihi limit";
//            return false;
//        }
//        creditCard.balance += price;
//        return true;
//    }
//
//    public void summary() {
//        System.out.println("Customer Name  : " + creditCard.getCustomer().getName());
//        System.out.println("Customer Email : " + creditCard.getCustomer().getEmail());
//        System.out.println("Bank           : " + creditCard.getAccount().getBank());
//        System.out.println("Account        : " + creditCard.getAccount().getCode());
//        System.out.println("Balance        : " + creditCard.getBalance());
//        System.out.println("Limit          : " + creditCard.getLimit());
//        System.out.println("status         : " + status);
//    }
//}
//
//class Customer {
//    private String name;
//    private String email;
//
//    public Customer(String name, String email) {
//        this.name = name;
//        this.email = email;
//    }
//
//    public Customer() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//}
//
//class Account{
//
//    private String code;
//    private Bank bank;
//
//    public Account(String code, Bank bank) {
//        this.code = code;
//        this.bank = bank;
//    }
//    public Bank getBank() {
//        return bank;
//    }
//
//    public void setBank(Bank bank) {
//        this.bank = bank;
//    }
//
//    public Account(String code) {
//        this.code = code;
//    }
//
//    public Account() {
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//
//}
//
//enum Bank {
//    BRI,BNI,BCA,MANDIRI
//}