package Models;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String title;
    private List<Ingredient> ingredients;
    private List<String> instructions;

    public Recipe(String title) {
        this.title = title;
        this.ingredients = new ArrayList<>();
        this.instructions = new ArrayList<>();
    }



    public String getTitle() {
        return title;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recept: ").append(title).append("\n");
        sb.append("Ingredienser:\n");
        for (Ingredient ingredient : ingredients) {
            sb.append("- ").append(ingredient.getName()).append(": ").append(ingredient.getQuantity()).append("\n");
        }
        sb.append("Instruktioner:\n");
        for (int i = 0; i < instructions.size(); i++) {
            sb.append((i + 1)).append(". ").append(instructions.get(i)).append("\n");
        }
        return sb.toString();
    }
}
