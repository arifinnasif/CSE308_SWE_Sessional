import FoodItems.AbstractFactory;
import FoodItems.Appetizers.BurgerWithFrenchFriesDecorator;
import FoodItems.Burger.BeefBurger;
import FoodItems.Burger.Burger;
import FoodItems.FactoryProducer;
import FoodItems.Toppings.CheesyBurgerDecorator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // print options
        System.out.println("1. Beef burger with French fry and cheese");
        System.out.println("2. Veggi burger with onion rings and Bottle of Water");
        System.out.println("3. A combo meal with Veggi burger, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi burger, Onion Rings, Coffee and Water");
        System.out.println("5. A Beef burger only");
        System.out.println("0. EXIT");


        Scanner sc = new Scanner(System.in);
        int ch = 0;
        while(true) {
            System.out.print("> ");
            ch = sc.nextInt();

            if(ch == 0) {
                break;
            }

            if(ch < 1 || ch > 5) {
                System.out.println("incorrect params");
                continue;
            }

            Burger borgir1 = null;
            AbstractFactory burgerFactory;

            if(ch==1) {
                burgerFactory = FactoryProducer.getFactory("BURGER");
                borgir1 = burgerFactory.getBurger("BEEF");

                AbstractFactory appetizerFactory = FactoryProducer.getFactory("APPETIZER");
                borgir1 = appetizerFactory.getAppetizerDecorator("FRENCH_FRIES", borgir1);

                AbstractFactory toppingsFactory = FactoryProducer.getFactory("TOPPINGS");
                borgir1 = toppingsFactory.getToppingsDecorator("CHEESE", borgir1);


            } else if (ch==2) {
                burgerFactory = FactoryProducer.getFactory("BURGER");
                borgir1 = burgerFactory.getBurger("VEGGI");

                AbstractFactory appetizerFactory = FactoryProducer.getFactory("APPETIZER");
                borgir1 = appetizerFactory.getAppetizerDecorator("ONION_RINGS", borgir1);

                AbstractFactory drinksFactory = FactoryProducer.getFactory("DRINKS");
                borgir1 = drinksFactory.getDrinksDecorator("WATER", borgir1);
            } else if (ch==3) {
                burgerFactory = FactoryProducer.getFactory("BURGER");
                borgir1 = burgerFactory.getBurger("VEGGI");

                AbstractFactory appetizerFactory = FactoryProducer.getFactory("APPETIZER");
                borgir1 = appetizerFactory.getAppetizerDecorator("FRENCH_FRIES", borgir1);

                AbstractFactory drinksFactory = FactoryProducer.getFactory("DRINKS");
                borgir1 = drinksFactory.getDrinksDecorator("COKE", borgir1);
            } else if (ch==4) {
                burgerFactory = FactoryProducer.getFactory("BURGER");
                borgir1 = burgerFactory.getBurger("VEGGI");

                AbstractFactory appetizerFactory = FactoryProducer.getFactory("APPETIZER");
                borgir1 = appetizerFactory.getAppetizerDecorator("ONION_RINGS", borgir1);

                AbstractFactory drinksFactory = FactoryProducer.getFactory("DRINKS");
                borgir1 = drinksFactory.getDrinksDecorator("COFFEE", borgir1);

                borgir1 = drinksFactory.getDrinksDecorator("WATER", borgir1);
            } else if (ch == 5) {
                burgerFactory = FactoryProducer.getFactory("BURGER");
                borgir1 = burgerFactory.getBurger("BEEF");
            }

            // show
            System.out.println(borgir1.getDescription());
            System.out.println(borgir1.getPrice());
        }



    }
}
