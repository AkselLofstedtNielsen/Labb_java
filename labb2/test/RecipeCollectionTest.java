import Models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCollectionTest {
    private RecipeCollection<BaseRecipe> collection;

    @BeforeEach
    void setUp() {
        collection = new RecipeCollection<>();
    }

    @Test
    void testAddRecipe() {
        Recipe recipe = new Recipe("Test Recept");
        collection.addRecipe(recipe);
        assertEquals(1, collection.getRecipes().size());
    }
    @Test
    void testViewRecipe() {
        Recipe recipe = new Recipe("Köttbullar");
        recipe.addIngredient(new Ingredient("Spaghetti", 400));
        recipe.addIngredient(new Ingredient("Köttbullar", 200));
        recipe.addInstruction("Koka pastan enligt instruktion.");
        recipe.addInstruction("Stek köttbullarna tills gyllenbruna.");

        collection.addRecipe(recipe);

        BaseRecipe retrievedRecipe = collection.getRecipes().get(0);
        String recipeDisplay = retrievedRecipe.toString();

        assertTrue(recipeDisplay.contains("Recept: Köttbullar"));
        assertTrue(recipeDisplay.contains("Typ: Ett standardrecept: Köttbullar"));
        assertTrue(recipeDisplay.contains("Spaghetti: 400.0"));
        assertTrue(recipeDisplay.contains("Köttbullar: 200.0"));
        assertTrue(recipeDisplay.contains("1. Koka pastan enligt instruktion."));
        assertTrue(recipeDisplay.contains("2. Stek köttbullarna tills gyllenbruna."));
    }

    @Test
    void testRemoveRecipe() {
        Recipe recipe = new Recipe("Test Recept");
        collection.addRecipe(recipe);
        collection.removeRecipe(recipe);
        assertTrue(collection.getRecipes().isEmpty());
    }

    @Test
    void testGetRecipesByType() {
        Recipe standardRecipe = new Recipe("Standard Recept");
        DessertRecipe dessertRecipe = new DessertRecipe("Dessert Recept", 100);
        collection.addRecipe(standardRecipe);
        collection.addRecipe(dessertRecipe);

        List<BaseRecipe> desserts = collection.getRecipesByType(DessertRecipe.class);
        assertEquals(1, desserts.size());
        assertTrue(desserts.get(0) instanceof DessertRecipe);
    }
}