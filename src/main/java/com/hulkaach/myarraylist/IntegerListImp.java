package com.hulkaach.myarraylist;

import java.util.Arrays;

public class IntegerListImp implements IntegerList {
    private final static int DEFAULT_CAPACITY = 10;
    private int size;
    private Integer[] storage;

    public IntegerListImp() {
        storage = new Integer[DEFAULT_CAPACITY];
    }

    public IntegerListImp(int initSize) {
        storage = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIndexToAdd(index);
        validateItem(item);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        return storage[index] = item;
    }

    @Override
    public Integer remove(Integer item) {
        int findIndex = indexOf(item);
        if (findIndex == -1) {
            throw new ElementNotFoundException();
        }
        remove(findIndex);
        return item;
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        int removed = storage[index];
        if (index == size - 1) {
            storage[--size] = null;
            return removed;
        } else {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            storage[--size] = null;
            return removed;
        }
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        Integer[] storageCopy = toArray();
        insertionSort(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        storage = new Integer[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new InvalidIndexException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    private void validateIndexToAdd(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void insertionSort(Integer[] arr) {
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

    private boolean binarySearch(Integer[] arr, Integer item) {
        int max = arr.length - 1;
        int min = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (item == arr[mid]) {
                return true;
            }
            if (item > arr[mid]) {
                min = mid + 1;
            }
            if (item < arr[mid]) {
                max = mid - 1;
            }
        }
        return false;
    }
}
