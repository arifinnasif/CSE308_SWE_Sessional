package FoodItems.Burger;

import FoodItems.AbstractFactory;

public class BurgerFactory extends AbstractFactory {
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
        return null;
    }

    @Override
    public Burger getBurger(String arg) {
        if("BEEF".equalsIgnoreCase(arg)) return new BeefBurger();
        else if("CHICKEN".equalsIgnoreCase(arg)) return new ChickenBurger();
        else if("VEGGI".equalsIgnoreCase(arg)) return new VeggiBurger();
        return null;
    }
}
