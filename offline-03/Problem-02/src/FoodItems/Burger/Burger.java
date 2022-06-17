package FoodItems.Burger;

public abstract class Burger {
    private int price;
    private String description;

    protected void setPrice(int price) {
        this.price = price;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
