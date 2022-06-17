package FoodItems;

import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public abstract class AbstractFactory {
    public abstract BurgerDecorator getAppetizerDecorator(String arg, Burger decoratedBurger);
    public abstract BurgerDecorator getDrinksDecorator(String arg, Burger decoratedBurger);
    public abstract BurgerDecorator getToppingsDecorator(String arg, Burger decoratedBurger);
    public abstract Burger getBurger(String arg);
}
