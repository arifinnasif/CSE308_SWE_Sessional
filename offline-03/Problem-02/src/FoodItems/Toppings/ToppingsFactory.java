package FoodItems.Toppings;

import FoodItems.AbstractFactory;
import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class ToppingsFactory extends AbstractFactory {

    @Override
    public BurgerDecorator getAppetizerDecorator(String arg, Burger decoratedBurger) {
        return null;
    }

    @Override
    public BurgerDecorator getDrinksDecorator(String arg, Burger decoratedBurger) {
        return null;
    }

    @Override
    public BurgerDecorator getToppingsDecorator(String arg, Burger decoratedBurger) {
        if("CHEESE".equalsIgnoreCase(arg)) return new CheesyBurgerDecorator(decoratedBurger);
        return null;
    }

    @Override
    public Burger getBurger(String arg) {
        return null;
    }
}
