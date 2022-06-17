import FoodItems.AbstractFactory;
import FoodItems.Appetizers.BurgerWithFrenchFriesDecorator;
import FoodItems.Burger.BeefBurger;
import FoodItems.Burger.Burger;
import FoodItems.FactoryProducer;
import FoodItems.Toppings.CheesyBurgerDecorator;

public class Main {
    public static void main(String[] args) {
        AbstractFactory burgerFactory = FactoryProducer.getFactory("BURGER");
        Burger borgir1 = burgerFactory.getBurger("BEEF");

        AbstractFactory toppingsFactory = FactoryProducer.getFactory("TOPPINGS");
        borgir1 = toppingsFactory.getToppingsDecorator("CHEESE", borgir1);

        AbstractFactory appetizerFactory = FactoryProducer.getFactory("APPETIZER");
        borgir1 = appetizerFactory.getAppetizerDecorator("FRENCH_FRIES", borgir1);

//        Burger borgir = new BeefBurger();
//        borgir = new CheesyBurgerDecorator(borgir);
//        borgir = new BurgerWithFrenchFriesDecorator(borgir);

        // show
        System.out.println(borgir1.getDescription());
        System.out.println(borgir1.getPrice());


        burgerFactory = FactoryProducer.getFactory("BURGER");
        Burger borgir2 = burgerFactory.getBurger("VEGGI");

        appetizerFactory = FactoryProducer.getFactory("APPETIZER");
        borgir2 = appetizerFactory.getAppetizerDecorator("ONION_RINGS", borgir2);

        AbstractFactory drinksFactory = FactoryProducer.getFactory("DRINKS");
        borgir2 = drinksFactory.getDrinksDecorator("WATER",  borgir2);


        // show
        System.out.println(borgir2.getDescription());
        System.out.println(borgir2.getPrice());


        burgerFactory = FactoryProducer.getFactory("BURGER");
        Burger borgir3 = burgerFactory.getBurger("VEGGI");

        appetizerFactory = FactoryProducer.getFactory("APPETIZER");
        borgir3 = appetizerFactory.getAppetizerDecorator("FRENCH_FRIES", borgir3);

        drinksFactory = FactoryProducer.getFactory("DRINKS");
        borgir3 = drinksFactory.getDrinksDecorator("COKE",  borgir3);


        // show
        System.out.println(borgir3.getDescription());
        System.out.println(borgir3.getPrice());


        burgerFactory = FactoryProducer.getFactory("BURGER");
        Burger borgir4 = burgerFactory.getBurger("VEGGI");

        appetizerFactory = FactoryProducer.getFactory("APPETIZER");
        borgir4 = appetizerFactory.getAppetizerDecorator("ONION_RINGS", borgir4);

        drinksFactory = FactoryProducer.getFactory("DRINKS");
        borgir4 = drinksFactory.getDrinksDecorator("COFFEE",  borgir4);
        borgir4 = drinksFactory.getDrinksDecorator("WATER",  borgir4);

        // show
        System.out.println(borgir4.getDescription());
        System.out.println(borgir4.getPrice());


        burgerFactory = FactoryProducer.getFactory("BURGER");
        Burger borgir5 = burgerFactory.getBurger("BEEF");

        // show
        System.out.println(borgir5.getDescription());
        System.out.println(borgir5.getPrice());
    }
}
