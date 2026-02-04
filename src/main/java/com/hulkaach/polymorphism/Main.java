package com.hulkaach.polymorphism;

public class Main {
    public static void main(String[] args) {
//        BankApplication bankApplication = new BankApplication();
        BankApplication bankApplication = new SberApplication();

        System.out.println(bankApplication.getType());
    }

}
