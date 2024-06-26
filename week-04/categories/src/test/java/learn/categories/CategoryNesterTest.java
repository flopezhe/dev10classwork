package learn.categories;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryNesterTest {

    @Test
    void mapCategories() {
        Category conductor = new Category(21, 0, "Conductor");
        Category orchestra = new Category(1, 0, "Orchestra");
        Category percussion = new Category(4, 1, "Percussion");
        Category triangles = new Category(19, 4, "Triangles");

        List<Category> categories = List.of(
                new Category(14, 4, "Timpani"),
                orchestra,
                new Category(2, 1, "Brass"),
                new Category(8, 5, "Cellos"),
                new Category(16, 4, "Snare Drums"),
                new Category(3, 1, "Woodwinds"),
                new Category(13, 3, "Oboes"),
                percussion,
                new Category(15, 2, "French Horns"),
                new Category(6, 5, "Violas"),
                new Category(11, 2, "Trombones"),
                new Category(7, 5, "Violins"),
                new Category(9, 5, "Bass"),
                new Category(10, 2, "Trumpets"),
                new Category(14, 3, "Bassoons"),
                new Category(12, 2, "Tubas"),
                new Category(17, 3, "Flutes"),
                new Category(18, 3, "Clarinets"),
                new Category(5, 1, "Strings"),
                triangles,
                new Category(20, 4, "Bass Drums"),
                conductor
        );

        List<Category> result = CategoryNester.nestCategories(categories);

        assertEquals(orchestra, result.get(0));
        assertEquals(conductor, result.get(1));

        assertEquals(4, orchestra.getSubCategories().size());
        assertTrue(conductor.getSubCategories().isEmpty());

        assertTrue(orchestra.getSubCategories().contains(percussion));
        assertTrue(percussion.getSubCategories().contains(triangles));
    }
}