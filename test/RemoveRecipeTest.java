import Models.Ingredient;
import Models.Recipe;
import Models.RecipeCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveRecipeTest {

    private RecipeCollection<Recipe> recipeCollection;

    @BeforeEach
    public void setUp() {
        // Initialisera en ny receptsamling
        recipeCollection = new RecipeCollection<>();
    }

    @Test
    public void testRemoveRecipe() {
        // Skapa och lägg till ett recept
        Recipe dinnerRecipe = new Recipe("Kycklinggryta");
        dinnerRecipe.addIngredient(new Ingredient("Kyckling", 500));
        recipeCollection.addRecipe(dinnerRecipe);

        // Ta bort receptet
        recipeCollection.removeRecipe(dinnerRecipe);

        // Kontrollera att receptet togs bort
        assertEquals(0, recipeCollection.getRecipes().size());
    }
}