package com.aad.termin19vezbanje.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String name;
    private List<Fruit> fruits;

    public Category() {

        fruits = new ArrayList<>();
    }

    public Category(int id, String name) {

        this.id = id;
        this.name = name;

        fruits = new ArrayList<>();
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void addFruit(Fruit fruit) {

        fruits.add(fruit);
    }

    public void removeFruit(Fruit fruit) {

        fruits.remove(fruit);
    }

    public Fruit getFruit(int position) {

        return fruits.get(position);
    }

    public List<Fruit> getFruits() {

        return fruits;
    }

    public void setFruits(List<Fruit> fruits) {

        this.fruits = fruits;
    }
}
