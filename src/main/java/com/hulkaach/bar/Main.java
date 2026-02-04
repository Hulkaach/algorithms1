package com.hulkaach.bar;

public class Main {
    public static void main(String[] args) {
        Person sarah = new Person("Sarah", 23, 1987123456);
        Person john = new Person("John", 33, 1987123456);
        AlcoholBar alcoholBar = new AlcoholBar();
        System.out.println(alcoholBar.acceptVisitor(sarah));
        System.out.println(alcoholBar.acceptVisitor(john));

    }
}
