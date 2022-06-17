package FoodItems;

import FoodItems.Appetizers.AppetizerDecoratorFactory;
import FoodItems.Burger.BurgerFactory;
import FoodItems.Drinks.DrinksDecoratorFactory;
import FoodItems.Toppings.ToppingsFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if("BURGER".equalsIgnoreCase(choice)) return new BurgerFactory();
        else if("APPETIZER".equalsIgnoreCase(choice)) return new AppetizerDecoratorFactory();
        else if("DRINKS".equalsIgnoreCase(choice)) return new DrinksDecoratorFactory();
        else if("TOPPINGS".equalsIgnoreCase(choice)) return new ToppingsFactory();
        return null;
    }
}
