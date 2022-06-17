package FoodItems.Toppings;


import FoodItems.Burger.Burger;
import FoodItems.Burger.BurgerDecorator;

public class CheesyBurgerDecorator extends BurgerDecorator {
    public CheesyBurgerDecorator(Burger decoratedBurger) {
        super(decoratedBurger);
    }

    @Override
    public String getDescription() {
        return decoratedBurger.getDescription() + ", Cheese";
    }

    @Override
    public int getPrice() {
        return decoratedBurger.getPrice() + 90;
    }
}
