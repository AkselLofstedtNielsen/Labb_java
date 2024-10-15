import Models.Ingredient;
import Models.Recipe;
import Models.RecipeCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewRecipeTest {

    private RecipeCollection<Recipe> recipeCollection;

    @BeforeEach
    public void setUp() {
        // Initialisera en ny receptsamling
        recipeCollection = new RecipeCollection<>();
    }

    @Test
    public void testViewRecipe() {
        // Skapa ett recept och lägg till ingredienser och instruktioner
        Recipe lunchRecipe = new Recipe("Pasta Carbonara");
        lunchRecipe.addIngredient(new Ingredient("Pasta", 200));
        lunchRecipe.addIngredient(new Ingredient("Guanciale", 100));
        lunchRecipe.addInstruction("Koka pastan.");
        lunchRecipe.addInstruction("Stek guanciale.");
        recipeCollection.addRecipe(lunchRecipe);

        // Hämta och visa receptet
        Recipe retrievedRecipe = recipeCollection.getRecipes().get(0);
        List<Ingredient> ingredients = retrievedRecipe.getIngredients();
        List<String> instructions = retrievedRecipe.getInstructions();

        // Kontrollera att ingredienser och instruktioner visas korrekt
        assertEquals("Pasta Carbonara", retrievedRecipe.getTitle());
        assertEquals(2, ingredients.size());
        assertEquals(2, instructions.size());
        assertEquals("Pasta", ingredients.get(0).getName());
        assertEquals("Koka pastan.", instructions.get(0));
    }
}