package FoodItems.Appetizers;

import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class BurgerWithFrenchFriesDecorator extends BurgerDecorator {

    public BurgerWithFrenchFriesDecorator(Burger decoratedBurger) {
        super(decoratedBurger);
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice() + 120;
    }

    @Override
    public String getDescription() {
        return decoratedBurger.getDescription() + ", French Fries";
    }
}
