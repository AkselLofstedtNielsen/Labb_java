import Models.Ingredient;
import Models.Recipe;
import Models.RecipeCollection;

import java.util.Scanner;

public class Main {

    private static RecipeCollection<Recipe> recipeCollection = new RecipeCollection<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    viewRecipe();
                    break;
                case 3:
                    removeRecipe();
                    break;
                case 4:
                    System.out.println("Avslutar programmet...");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }

    }

    private static void printMenu() {
        System.out.println("\n--- Recept Hantering ---");
        System.out.println("1. Lägg till recept");
        System.out.println("2. Visa alla recept");
        System.out.println("3. Ta bort ett recept");
        System.out.println("4. Avsluta");
        System.out.print("Välj ett alternativ: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Felaktig inmatning! Ange ett nummer.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addRecipe() {
        //TODO

    }

    private static void viewRecipe() {
        //TODO

    }

    private static void removeRecipe() {
        //TODO

    }


}
