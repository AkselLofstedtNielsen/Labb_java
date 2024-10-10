import Models.Ingredient;
import Models.Recipe;
import Models.RecipeCollection;

import java.util.Scanner;

public class Main {

    private static RecipeCollection<Recipe> recipeCollection = new RecipeCollection<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



    }

    private static void printMenu() {
        System.out.println("\n--- Recept Hantering ---");
        System.out.println("1. Lägg till recept");
        System.out.println("2. Visa alla recept");
        System.out.println("3. Ta bort ett recept");
        System.out.println("4. Avsluta");
        System.out.print("Välj ett alternativ: ");
    }

    private static int getUserChoice () {
        return 0;
    }

    private static void addRecipe() {

    }

    private static void viewRecipe() {

    }

    private static void removeRecipe() {

    }


}
