package com.hulkaach.potter;

import java.util.List;

public class NaivePotionHomework implements PotionHomework {
    private final Brewery brewery;

    public NaivePotionHomework(Brewery brewery) {
        this.brewery = brewery;
    }

    @Override
    public void printAllCombinations(List<Potion> potions) {
        int iteration = 1;
        for (int i = 0; i < potions.size(); i++) {
            final Potion first = potions.get(i);
            for (int j = 0; j < potions.size(); j++) {
                final Potion second = potions.get(j);
                Potion mix = brewery.mix(first, second);
                System.out.println(iteration + ". " + first + " + " + second + " " + mix);
                iteration++;
            }
        }
    }
}
