package FoodItems.Appetizers;

import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class BurgerWithOnionRingsDecorator extends BurgerDecorator {
    public BurgerWithOnionRingsDecorator(Burger decoratedBurger) {
        super(decoratedBurger);
    }

    @Override
    public String getDescription() {
        return decoratedBurger.getDescription() + ", Onion Rings";
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice() + 350;
    }
}
