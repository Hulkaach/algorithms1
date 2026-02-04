package com.hulkaach.bar;

public class Person {
    private final String name;
    private final int age;
    private final int passport;

    public Person(String name, int age, int passport) {
        this.name = name;
        this.age = age;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPassport() {
        return passport;
    }
}
