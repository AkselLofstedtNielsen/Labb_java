import Models.Ingredient;
import Models.Recipe;
import Models.RecipeCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRecipeTest {

    private RecipeCollection<Recipe> recipeCollection;

    @BeforeEach
    public void setUp() {
        // Initialisera en ny receptsamling
        recipeCollection = new RecipeCollection<>();
    }

    @Test
    public void testAddRecipe() {
        // Skapa ett nytt recept och lägg till det
        Recipe breakfastRecipe = new Recipe("Omelett");
        breakfastRecipe.addIngredient(new Ingredient("Ägg", 3));
        recipeCollection.addRecipe(breakfastRecipe);

        // Kontrollera att receptet lades till korrekt
        assertEquals(1, recipeCollection.getRecipes().size());
        assertEquals("Omelett", recipeCollection.getRecipes().get(0).getTitle());
    }
}
