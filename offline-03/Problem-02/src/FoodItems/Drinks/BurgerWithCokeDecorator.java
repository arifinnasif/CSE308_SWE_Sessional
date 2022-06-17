package FoodItems.Drinks;

import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class BurgerWithCokeDecorator extends BurgerDecorator {
    public BurgerWithCokeDecorator(Burger decoratedBurger) {
        super(decoratedBurger);
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice() + 40;
    }

    @Override
    public String getDescription() {
        return decoratedBurger.getDescription() + ", Coke";
    }
}
