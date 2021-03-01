package Main;

import Entity.Fruit;

import Entity.Validation;
import GUI.FruitGUI;

import static Entity.Manager.listFruit;

public class Main {
    public static void main(String[] args) {
        listFruit.add(new Fruit("009", "Carambola", 10, 9, "America"));
        listFruit.add(new Fruit("005", "Blackberries", 10, 10, "America"));
        listFruit.add(new Fruit("001", "Acerola", 10, 5, "America"));
        listFruit.add(new Fruit("002", "Apple", 10, 3, "Vietnam"));
        listFruit.add(new Fruit("007", "Breadfruit", 10, 6, "America"));
        listFruit.add(new Fruit("003", "Apricot", 20, 4, "America"));
        listFruit.add(new Fruit("004", "Avocado", 15, 2, "Thailand"));
        listFruit.add(new Fruit("006", "Blackcurrant", 7, 8, "America"));
        listFruit.add(new Fruit("008", "Cantaloupe", 10, 5, "America"));

        while (true) {
            System.out.println("============= WELCOME TO THE FRUIT SHOP =============");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validation.checkInputIntLimit(1, 4);

            switch (choice) {
                case 1:
                    FruitGUI.createFruit();
                    break;
                case 2:
                    FruitGUI.viewOrder();
                    break;
                case 3:
                    FruitGUI.shopping();
                    break;
                case 4:
                    return;
            }
        }
    }
}
