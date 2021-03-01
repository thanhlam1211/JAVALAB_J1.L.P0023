package GUI;

import Entity.Fruit;
import Entity.Manager;
import Entity.Order;
import Entity.Validation;

import java.util.ArrayList;

import static Entity.Manager.listFruit;
import static Entity.Manager.listOrder;

public class FruitGUI {

    public static void createFruit() {
        while (true) {
            System.out.print("Enter fruit ID: ");
            String fruitID = Validation.checkInputString();
            if(!Validation.checkInputFruitID(fruitID)){
                return;
            }
            System.out.print("Enter fruit name: ");
            String name = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            listFruit.add(new Fruit(fruitID, name, quantity, price, origin));
            System.out.print("Do you want to continue (Y/N)? :");
            if(!Validation.checkInputYN()) {
                return;
            }
        }
    }

    public static void viewOrder(){
        Manager.viewOrder();
    }

    public static void shopping(){
        Manager.shopping();
    }
}
