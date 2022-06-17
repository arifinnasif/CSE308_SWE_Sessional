package FoodItems.Drinks;

import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class BurgerWithCoffeeDecorator extends BurgerDecorator {

    public BurgerWithCoffeeDecorator(Burger decoratedBurger) {
        super(decoratedBurger);
    }

    @Override
    public String getDescription() {
        return decoratedBurger.getDescription() + ", Coffee";
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice() + 100;
    }
}
