package FoodItems.Drinks;

import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class BurgerWithWaterDecorator extends BurgerDecorator {

    public BurgerWithWaterDecorator(Burger decoratedBurger) {
        super(decoratedBurger);
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice() + 20;
    }

    @Override
    public String getDescription() {
        return decoratedBurger.getDescription() + ", Water";
    }
}
