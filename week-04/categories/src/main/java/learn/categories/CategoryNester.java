package learn.categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryNester {

    public static List<Category> nestCategories(List<Category> categories) {
        return nestCategories(categories, 0);
    }

    public static List<Category> nestCategories(List<Category> categories, int parentId) {
        return List.of();
    }


}
