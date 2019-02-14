package com.aad.termin19vezbanje.providers;

import com.aad.termin19vezbanje.model.Category;
import com.aad.termin19vezbanje.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitProvider {

    public static List<Fruit> getFruits() {

        Category rose = new Category(0, "Rose");
        Category citrus = new Category(1, "Citrus");
        Category berry = new Category(2, "Berry");

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(0, "apples.jpg", "Apples", "The apple tree is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple.", 5.0f, rose));
        fruits.add(new Fruit(1, "bananas.jpg", "Bananas", "The banana is an edible fruit, botanically a berry, produced by several kinds of large herbaceous flowering plants in the genus Musa.", 4.0f, berry));
        fruits.add(new Fruit(2, "oranges.jpg", "Oranges", "The orange is the fruit of the citrus species Citrus in the family Rutaceae.", 3.0f, citrus));
        return fruits;
    }

    public static List<String> getFruitNames() {

        List<String> names = new ArrayList<>();
        names.add("Apples");
        names.add("Bananas");
        names.add("Oranges");
        return names;
    }

    public static Fruit getFruitById(int id) {

        Category rose = new Category(0, "Rose");
        Category citrus = new Category(1, "Citrus");
        Category berry = new Category(2, "Berry");

        switch (id) {
            case 0:
                return new Fruit(0, "apples.jpg", "Apples", "The apple tree is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple.", 5.0f, rose);
            case 1:
                return new Fruit(1, "bananas.jpg", "Bananas", "The banana is an edible fruit, botanically a berry, produced by several kinds of large herbaceous flowering plants in the genus Musa.", 4.0f, berry);
            case 2:
                return new Fruit(2, "oranges.jpg", "Oranges", "The orange is the fruit of the citrus species Citrus in the family Rutaceae.", 3.0f, citrus);
            default:
                return null;
        }
    }
}
