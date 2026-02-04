package com.hulkaach.potter;

public class HashingBrewery implements Brewery {
    @Override
    public Potion mix(Potion first, Potion second) {
        if (first == second) {
            return first;
        }

        String a = first.getName();
        String b = second.getName();

        // нормализация порядка
        String key = a.compareTo(b) <= 0
                ? a + "|" + b
                : b + "|" + a;

        return new Potion(Integer.toHexString(key.hashCode()));
    }
}