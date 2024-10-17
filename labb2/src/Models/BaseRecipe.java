package Models;

public abstract class BaseRecipe {
    protected String title;

    public BaseRecipe(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getDescription();
}