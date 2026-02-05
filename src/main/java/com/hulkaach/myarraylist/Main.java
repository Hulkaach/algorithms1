package com.hulkaach.myarraylist;

import java.util.Arrays;
import java.util.Random;

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
        stringList.add(4, "a");
        System.out.println("stringList = " + stringList);

        stringList.remove("a");
        System.out.println("stringList = " + stringList);

        Random random = new Random();
        int[] array1 = new int[100_000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(0, 100_101);
        }
        int[] array2 = Arrays.copyOf(array1, array1.length);
        int[] array3 = Arrays.copyOf(array1, array1.length);

        long start = System.currentTimeMillis();
        bubbleSort(array2);
        long total = System.currentTimeMillis() - start;


        long start2 = System.currentTimeMillis();
        selectionSort(array1);
        long total2 = System.currentTimeMillis() - start2;

        long start3 = System.currentTimeMillis();
        insertionSort(array3);
        long total3 = System.currentTimeMillis() - start3;


        System.out.println("bubbleSort = " + total + " ms");
        System.out.println("selectionSort = " + total2 + " ms");
        System.out.println("insertionSort = " + total3 + " ms");
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int currentIndex = arr.length - 1; currentIndex >= 0; currentIndex--) {
            int max = Integer.MIN_VALUE;
            int idxMax = 0;
            for (int i = 0; i <= currentIndex; i++) {
                int el = arr[i];
                if (max < el) {
                    max = el;
                    idxMax = i;
                }
            }
            int temp = arr[currentIndex];
            arr[currentIndex] = max;
            arr[idxMax] = temp;
        }
    }

    private static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
