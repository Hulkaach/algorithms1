package com.hulkaach.myarraylist;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final double MAX_CAPACITY = 0.8;
    private final int DEFAULT_SIZE = 10;
    private int size;
    private String[] storage;
    private int index;

    public StringListImpl() {
        storage = new String[DEFAULT_SIZE];
    }

    public StringListImpl(int size) {
        this.size = size;
        this.storage = new String[size];
        this.index = 0;
    }

    @Override
    public String add(String item) {
        isNotNull(item);
        if (index >= size * MAX_CAPACITY) {
            String[] newArray = new String[size * 2];
            for (int i = 0; i < this.index; i++) {
                newArray[i] = storage[i];
            }
            storage = newArray;
            size = size * 2;
        }
        storage[index] = item;
        index++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        isNotNull(item);
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index < (this.index)) {
            throw new IllegalArgumentException("This position at array already busy");
        }
        storage[index] = item;
        this.index++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        isNotNull(item);
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return storage[index] = item;
    }

    @Override
    public String remove(String item) {
        isNotNull(item);
        for (int i = 0; i < this.index; i++) {
            if (storage[i].equals(item)) {
                for (int j = i; j < this.index - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[index - 1] = null;
                index--;
                return item;
            }
        }
        throw new NotFoundAtArrayException("Not found item at array");
    }

    @Override
    public String remove(int index) {
        if (index >= this.index || index < 0) {
            throw new NotFoundAtArrayException("No element at index " + index);
        }
        String removed = storage[index];
        for (int i = index; i < this.index - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[this.index - 1] = null;
        this.index--;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        isNotNull(item);
        boolean flag = false;
        for (int i = 0; i < this.index; i++) {
            if (storage[i].equals(item)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public int indexOf(String item) {
        isNotNull(item);
        for (int i = 0; i < index; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        isNotNull(item);
        for (int i = index - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= this.index) {
            throw new NotFoundAtArrayException("No element at index " + index);
        } else {
            return storage[index];
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null || otherList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (otherList.size() != index) {
            return false;
        }
        for (int i = 0; i < this.index - 1; i++) {
            if (!storage[i].equals(otherList.toArray()[i])) {
                return false;
            }

        }
        return true;
    }

    @Override
    public int size() {
        return this.index;
    }

    @Override
    public boolean isEmpty() {
        return this.index == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < index; i++) {
            storage[i] = null;
        }
        index = 0;
    }

    @Override
    public String[] toArray() {
        if (this.index == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        String[] newArray = new String[this.index];
        for (int i = 0; i < index; i++) {
            newArray[i] = this.storage[i];
        }
        return newArray;
    }

    private void isNotNull(String item) {
        if (item == null || item.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
    private int getCapacity() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }
}
