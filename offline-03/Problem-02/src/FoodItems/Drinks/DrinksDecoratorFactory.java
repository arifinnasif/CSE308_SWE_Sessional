package FoodItems.Drinks;

import FoodItems.AbstractFactory;
import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class DrinksDecoratorFactory extends AbstractFactory {
    @Override
    public BurgerDecorator getAppetizerDecorator(String arg, Burger decoratedBurger) {
        return null;
    }

    @Override
    public BurgerDecorator getDrinksDecorator(String arg, Burger decoratedBurger) {
        if("COFFEE".equalsIgnoreCase(arg)) return new BurgerWithCoffeeDecorator(decoratedBurger);
        else if("COKE".equalsIgnoreCase(arg)) return new BurgerWithCokeDecorator(decoratedBurger);
        else if("WATER".equalsIgnoreCase(arg)) return new BurgerWithWaterDecorator(decoratedBurger);
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
