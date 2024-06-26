package learn.categories;

import java.util.*;

public class Category {
    private int id;
    private int parentId;
    private String name;
    private final ArrayList<Category> subCategories = new ArrayList<>();

    public Category() {

    }

    public Category(int id, int parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getSubCategories() {
        return new ArrayList<>(subCategories);
    }

    public boolean addSubCategory(Category subCategory) {
        return this.subCategories.add(subCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && parentId == category.parentId && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name);
    }
}
