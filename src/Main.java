import Models.Ingredient;
import Models.Recipe;
import Models.RecipeCollection;

public class Main {
    public static void main(String[] args) {
        // Skapa recept
        Recipe breakfastRecipe = new Recipe("Omelett");
        breakfastRecipe.addIngredient(new Ingredient("Ägg", 3));
        breakfastRecipe.addIngredient(new Ingredient("Mjölk", 50));
        breakfastRecipe.addIngredient(new Ingredient("Salt", 1));
        breakfastRecipe.addInstruction("Vispa ägg och mjölk.");
        breakfastRecipe.addInstruction("Tillsätt salt.");
        breakfastRecipe.addInstruction("Stek i panna tills gyllenbrun.");

        Recipe dinnerRecipe = new Recipe("Kycklinggryta");
        dinnerRecipe.addIngredient(new Ingredient("Kyckling", 500));
        dinnerRecipe.addIngredient(new Ingredient("Grönsaker", 300));
        dinnerRecipe.addIngredient(new Ingredient("Grädde", 200));
        dinnerRecipe.addInstruction("Stek kyckling.");
        dinnerRecipe.addInstruction("Lägg i grönsaker och grädde.");
        dinnerRecipe.addInstruction("Låt koka tills grönsakerna är mjuka.");

        // Skapa en samling av recept
        RecipeCollection<Recipe> recipeCollection = new RecipeCollection<>();
        recipeCollection.addRecipe(breakfastRecipe);
        recipeCollection.addRecipe(dinnerRecipe);

        // Visa alla recept
        System.out.println("Alla recept:");
        for (Recipe recipe : recipeCollection.getRecipes()) {
            System.out.println(recipe);
        }

        // Ta bort ett recept (t.ex. middagsreceptet)
        recipeCollection.removeRecipe(dinnerRecipe);

        // Visa kvarvarande recept
        System.out.println("\nEfter borttagning:");
        for (Recipe recipe : recipeCollection.getRecipes()) {
            System.out.println(recipe);
        }
    }
}
