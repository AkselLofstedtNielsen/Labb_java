package Models;

import java.util.ArrayList;
import java.util.List;

public class RecipeCollection<T extends Recipe> {
    private List<T> recipes;

    public RecipeCollection() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(T recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(T recipe) {
        this.recipes.remove(recipe);
    }

    public List<T> getRecipes() {
        return recipes;
    }
}
