package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeCollection<T extends BaseRecipe> {
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

    public List<T> getRecipesByType(Class<? extends T> recipeType) {
        return recipes.stream()
                .filter(recipeType::isInstance)
                .collect(Collectors.toList());
    }
}