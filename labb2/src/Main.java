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
                    viewRecipes();
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
        System.out.println("\n== Lägg till ett nytt recept ==");
        System.out.print("Ange receptets titel: ");
        scanner.nextLine();  // Rensa scanner
        String title = scanner.nextLine();

        Recipe recipe = new Recipe(title);

        boolean addingIngredients = true;
        while (addingIngredients) {
            System.out.print("Ange ingrediensens namn (eller 'klar' för att avsluta): ");
            String ingredientName = scanner.nextLine();
            if (ingredientName.equalsIgnoreCase("klar")) {
                addingIngredients = false;
            } else {
                System.out.print("Ange mängd för " + ingredientName + ": ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Felaktig inmatning! Ange en siffra.");
                    scanner.next();  // Ignorera felaktig inmatning
                }
                double quantity = scanner.nextDouble();
                scanner.nextLine();  // Rensa scanner
                recipe.addIngredient(new Ingredient(ingredientName, quantity));
            }
        }

        boolean addingInstructions = true;
        while (addingInstructions) {
            System.out.print("Ange en instruktion (eller 'klar' för att avsluta): ");
            String instruction = scanner.nextLine();
            if (instruction.equalsIgnoreCase("klar")) {
                addingInstructions = false;
            } else {
                recipe.addInstruction(instruction);
            }
        }

        recipeCollection.addRecipe(recipe);
        System.out.println("Receptet '" + title + "' har lagts till.");
    }

    private static void viewRecipes() {
        System.out.println("\n== Visa alla recept ==");
        if (recipeCollection.getRecipes().isEmpty()) {
            System.out.println("Inga recept tillgängliga.");
        } else {
            for (Recipe recipe : recipeCollection.getRecipes()) {
                System.out.println(recipe);
                System.out.println("-----------------------------");
            }
        }
    }

    private static void removeRecipe() {
        System.out.println("\n== Ta bort ett recept ==");
        if (recipeCollection.getRecipes().isEmpty()) {
            System.out.println("Inga recept att ta bort.");
            return;
        }

        System.out.println("Välj vilket recept du vill ta bort:");
        for (int i = 0; i < recipeCollection.getRecipes().size(); i++) {
            System.out.println((i + 1) + ". " + recipeCollection.getRecipes().get(i).getTitle());
        }

        System.out.print("Ange numret för receptet du vill ta bort: ");
        int recipeIndex = getUserChoice() - 1;

        if (recipeIndex >= 0 && recipeIndex < recipeCollection.getRecipes().size()) {
            Recipe recipeToRemove = recipeCollection.getRecipes().get(recipeIndex);
            recipeCollection.removeRecipe(recipeToRemove);
            System.out.println("Receptet '" + recipeToRemove.getTitle() + "' har tagits bort.");
        } else {
            System.out.println("Ogiltigt val. Försök igen.");
        }
    }
}
