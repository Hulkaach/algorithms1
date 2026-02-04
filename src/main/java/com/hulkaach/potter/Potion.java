package com.hulkaach.potter;

public class Potion {
    private final String name;

    public Potion(String name) {
        this.name = name;
    }

    public Potion(Potion source) {
        this.name = source.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if (!other.getClass().equals(this.getClass())) {
            return false;
        }
        return ((Potion) other).name.equals(name);
    }

    public String getName() {
        return name;
    }
}
