package FoodItems.Appetizers;

import FoodItems.AbstractFactory;
import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class AppetizerDecoratorFactory extends AbstractFactory {

    @Override
    public BurgerDecorator getAppetizerDecorator(String arg, Burger decoratedBurger) {
        if("FRENCH_FRIES".equalsIgnoreCase(arg)) return new BurgerWithFrenchFriesDecorator(decoratedBurger);
        else if ("ONION_RINGS".equalsIgnoreCase(arg)) return new BurgerWithOnionRingsDecorator(decoratedBurger);
        return null;
    }

    @Override
    public BurgerDecorator getDrinksDecorator(String arg, Burger decoratedBurger) {
        return null;
    }

    @Override
    public BurgerDecorator getToppingsDecorator(String arg, Burger decoratedBurger) {
        return null;
    }

    @Override
    public Burger getBurger(String arg) {
        return null;
    }
}
