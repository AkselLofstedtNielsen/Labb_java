package Models;

public class DessertRecipe extends Recipe {
    private int sugarContent;

    public DessertRecipe(String title, int sugarContent) {
        super(title);
        this.sugarContent = sugarContent;
    }

    @Override
    public String getDescription() {
        return "Ett dessertrecept: " + getTitle() + " med " + sugarContent + "g socker";
    }
}