package com.hulkaach.potter;

import java.util.List;

public class FindPotionsIngredientsMission {
    private final Brewery brewery;

    public FindPotionsIngredientsMission(Brewery brewery) {
        this.brewery = brewery;
    }


    public void printPotionIngredients(List<Potion> potions, Potion needle) {
        int iteration = 1;
        for (int i = 0; i < potions.size(); i++) {
            Potion first = potions.get(i);
            for (int j = i + 1; j < potions.size(); j++) {
                Potion second = potions.get(j);
                Potion mix = brewery.mix(first, second);
                if (mix.equals(needle)) {
                    System.out.println(iteration + ". " + first + " + " + second + " " + mix);
                    return;
                }
                iteration++;
            }
        }
        System.out.println("Potion not found");
    }
}
