package com.hulkaach.potter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Potion> potions = List.of(
//                new Potion("Fake potion 1"),
//                new Potion("Fake potion 2"),
//                new Potion("Fake potion 3"),
//                new Potion("Fake potion 4"),
//                new Potion("Fake potion 5"),
//                new Potion("Fake potion 6"),
                new Potion("Polyjuice"),
                new Potion("Fame"),
                new Potion("Felicicus Melonus"),
                new Potion("Varitas Serum"),
                new Potion("Sleep"),
                new Potion("Girding potion"),
                new Potion("Love potion"),
                new Potion("Comed tea"),
                new Potion("Invisibility potion"),
                new Potion("Pepperup Potion")
        );

//        PotionHomework potionHomework = new NaivePotionHomework(new HashingBrewery());
//        PotionHomework potionHomework = new SkipSelfMixPotionHomework(new HashingBrewery());
//        PotionHomework potionHomework = new SkipDoublesPotionHomework(new HashingBrewery());
//        potionHomework.printAllCombinations(potions);

        FindPotionsIngredientsMission potionsMission = new FindPotionsIngredientsMission(new HashingBrewery());
        potionsMission.printPotionIngredients(potions, new Potion("87f37296"));
    }
}
