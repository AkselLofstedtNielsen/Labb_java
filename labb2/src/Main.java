import Models.BaseRecipe;
import Models.Recipe;
import Models.DessertRecipe;
import Models.Ingredient;
import Models.RecipeCollection;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

    private static RecipeCollection<BaseRecipe> recipeCollection = new RecipeCollection<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice(1, 5);
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
                    searchRecipes();
                    break;
                case 5:
                    System.out.println("Avslutar programmet...");
                    running = false;
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Recept Hantering ---");
        System.out.println("1. Lägg till recept");
        System.out.println("2. Visa alla recept");
        System.out.println("3. Ta bort ett recept");
        System.out.println("4. Sök recept");
        System.out.println("5. Avsluta");
        System.out.print("Välj ett alternativ: ");
    }

    private static int getUserChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Ogiltigt val. Ange ett nummer mellan " + min + " och " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning! Ange ett nummer.");
            }
        }
    }

    private static void addRecipe() {
        System.out.println("\n== Lägg till ett nytt recept ==");
        String title = getValidInput("Ange receptets titel: ", false);

        System.out.print("Är detta ett dessertrecept? (ja/nej): ");
        boolean isDessert = scanner.nextLine().trim().equalsIgnoreCase("ja");

        BaseRecipe recipe;
        if (isDessert) {
            int sugarContent = getValidInt("Ange sockerhalt i gram: ");
            recipe = new DessertRecipe(title, sugarContent);
        } else {
            recipe = new Recipe(title);
        }

        if (recipe instanceof Recipe) {
            Recipe conreteRecipe = (Recipe) recipe;


            while (true) {
                String ingredientName = getValidInput("Ange ingrediensens namn (eller 'klar' för att avsluta): ", true);
                if (ingredientName.equalsIgnoreCase("klar")) {
                    break;
                }

                double quantity = getValidDouble("Ange mängd för " + ingredientName + ": ");
                conreteRecipe.addIngredient(new Ingredient(ingredientName, quantity));
            }

            while (true) {
                String instruction = getValidInput("Ange en instruktion (eller 'klar' för att avsluta): ", true);
                if (instruction.equalsIgnoreCase("klar")) {
                    break;
                }
                conreteRecipe.addInstruction(instruction);
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
            for (BaseRecipe recipe : recipeCollection.getRecipes()) {
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

        try {
            int recipeIndex = getUserChoice(1, recipeCollection.getRecipes().size()) - 1;
            BaseRecipe recipeToRemove = recipeCollection.getRecipes().get(recipeIndex);
            recipeCollection.removeRecipe(recipeToRemove);
            System.out.println("Receptet '" + recipeToRemove.getTitle() + "' har tagits bort.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ogiltigt val. Inget recept togs bort.");
        }
    }

    // @TODO: Implementera sökning av recept på ingredienser
    private static void searchRecipes() {
        System.out.println("Denna funktion är inte implementerad än.");
    }

    private static String getValidInput(String prompt, boolean allowEmpty) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty() || allowEmpty) {
                return input;
            }
            System.out.println("Inmatning kan inte vara tom. Försök igen.");
        }
    }

    private static double getValidDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning. Ange ett giltigt nummer.");
            }
        }
    }

    private static int getValidInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning. Ange ett heltal.");
            }
        }
    }
}