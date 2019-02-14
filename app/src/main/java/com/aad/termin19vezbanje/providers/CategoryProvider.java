package com.aad.termin19vezbanje.providers;

import com.aad.termin19vezbanje.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryProvider {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Rose"));
        categories.add(new Category(1, "Citrus"));
        categories.add(new Category(2, "Berry"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Rose");
        names.add("Citrus");
        names.add("Berry");
        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Rose");
            case 1:
                return new Category(1, "Citrus");
            case 2:
                return new Category(2, "Berry");
            default:
                return null;
        }
    }
}
