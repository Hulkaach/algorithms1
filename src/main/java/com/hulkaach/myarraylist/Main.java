package com.hulkaach.myarraylist;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl(5);
        System.out.println("stringList = " + stringList);
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        System.out.println("stringList = " + stringList);
        System.out.println("stringList.getIndex() = " + stringList.size());
//        stringList.add("e");
        System.out.println("stringList = " + stringList);
        System.out.println("stringList.getIndex() = " + stringList.size());
        stringList.add(4,"a");
        System.out.println("stringList = " + stringList);

        stringList.remove("a");
        System.out.println("stringList = " + stringList);
    }
}
