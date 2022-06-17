package FoodItems.Burger;

public abstract class BurgerDecorator extends Burger {
    protected Burger decoratedBurger;

    public BurgerDecorator(Burger decoratedBurger) {
        this.decoratedBurger = decoratedBurger;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
