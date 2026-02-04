package com.hulkaach.myarraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private final String ITEM1 = "a";
    private final String ITEM2 = "b";
    private final String ITEM3 = "c";
    private final String ITEM4 = "d";
    private final String ITEM5 = "e";
    private final int CAPACITY = 10;
    StringListImpl list;

    @BeforeEach
    void setUp() {
        list = new StringListImpl(CAPACITY);
    }

    @Test
    void getIndex() {
        assertEquals(0, list.size());
        list.add(ITEM1);
        list.add(ITEM2);
        assertEquals(2, list.size());
    }

    @Test
    void addItemInArrayWithoutIndex() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        list.add(ITEM4);
        list.add(ITEM5);
        assertEquals(ITEM1, list.get(0));
        assertEquals(ITEM2, list.get(1));
        assertEquals(ITEM3, list.get(2));
        assertEquals(ITEM4, list.get(3));
        assertEquals(ITEM5, list.get(4));
    }

    @Test
    void addItemInArrayWithIndex() {
        list.add(2, ITEM1);
        assertEquals(ITEM1, list.get(2));
    }

    @Test
    void shouldThrowIndexExceptionWhenIndexMoreOrEqualCapacity() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(CAPACITY, ITEM1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(CAPACITY + 1, ITEM1));
    }

    @Test
    void shouldThrowIndexExceptionWhenIndexIsNegative() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-2, ITEM1));
    }

    @Test
    void shouldThrowExceptionThenIndexIsBusy() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        list.add(ITEM4);
        list.add(ITEM5);
        assertThrows(IllegalArgumentException.class, () -> list.add(2, ITEM1));
    }

    @Test
    void set() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        list.add(ITEM4);
        list.add(ITEM5);
        list.set(0, ITEM5);
        assertEquals(ITEM5, list.get(0));
    }

    @Test
    void shouldRemoveElementByName() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertEquals(3, list.size());
        list.remove(ITEM1);
        assertEquals(ITEM2, list.get(0));
        assertEquals(ITEM3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void shouldThrowExceptionWhenNotFindElementToRemove() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertEquals(3, list.size());
        assertThrows(NotFoundAtArrayException.class, () -> list.remove(ITEM5));
    }

    @Test
    void shouldRemoveElementByIndex() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertEquals(3, list.size());
        list.remove(0);
        assertEquals(ITEM2, list.get(0));
        assertEquals(ITEM3, list.get(1));
    }

    @Test
    void shouldThrowExceptionWhenIndexRemovableElementOutOfRange() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertEquals(3, list.size());
        assertThrows(NotFoundAtArrayException.class, () -> list.remove(3));
    }

    @Test
    void contains() {
        list.add(ITEM1);
        list.add(ITEM2);
        assertTrue(list.contains(ITEM1));
        assertTrue(list.contains(ITEM2));
        assertFalse(list.contains(ITEM3));
    }

    @Test
    void indexOf() {
        list.add(ITEM1);
        list.add(ITEM2);
        assertEquals(1, list.indexOf(ITEM2));
        assertEquals(-1, list.indexOf(ITEM3));
    }

    @Test
    void lastIndexOf() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM2);
        list.add(ITEM2);
        assertEquals(3, list.lastIndexOf(ITEM2));
        assertEquals(-1, list.indexOf(ITEM3));
    }

    @Test
    void get() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM2);
        list.add(ITEM2);
        assertEquals(ITEM2, list.get(1));
    }

    @Test
    void shouldThrowNotFoundExceptionWhenIndexOutOfRange() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM2);
        list.add(ITEM2);
        assertThrows(NotFoundAtArrayException.class, () -> list.get(5));
        assertThrows(NotFoundAtArrayException.class, () -> list.get(-1));
    }

    @Test
    void testEquals() {
        StringListImpl otherList = new StringListImpl(3);
        otherList.add(ITEM1);
        otherList.add(ITEM2);
        otherList.add(ITEM3);
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertTrue(list.equals(otherList));
        otherList.add(ITEM3);
        assertFalse(list.equals(otherList));
    }

    @Test
    void size() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertEquals(3, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add(ITEM1);
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void toArray() {
        list.add(ITEM1);
        list.add(ITEM2);
        list.add(ITEM3);
        String[] array = list.toArray();
        assertEquals(3,array.length);
        assertEquals(list.get(0),array[0]);
        assertEquals(list.get(1),array[1]);
        assertEquals(list.get(2),array[2]);
    }
}