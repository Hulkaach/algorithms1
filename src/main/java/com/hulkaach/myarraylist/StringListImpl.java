package com.hulkaach.myarraylist;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final int DEFAULT_SIZE = 10;
    private int size;
    private String[] storage;

    public StringListImpl() {
        storage = new String[DEFAULT_SIZE];
    }

    public StringListImpl(int initSize) {
        storage = new String[initSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
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
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        return storage[index] = item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        remove(index);
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String removed = storage[index];
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
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        storage = new String[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
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

    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }
}
