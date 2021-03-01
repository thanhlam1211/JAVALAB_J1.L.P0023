package Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;

public class Manager {
    public static ArrayList<Fruit> listFruit = new ArrayList<>();
    public static Hashtable<String, ArrayList<Order>> listOrder = new Hashtable<>();

    public static void viewOrder() {
        if (listOrder.keySet().isEmpty()) {
            System.out.println("No order have made yet");
            System.out.println();
            return;
        }
        for (String name : listOrder.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> orderList = listOrder.get(name);
            Manager.displayListOrder(orderList);
        }
    }

    public static void displayListOrder(ArrayList<Order> orderList) {
        double total = 0;
        System.out.printf("%15s | %15s | %15s | %15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : orderList) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
            order.setTotal(total);
        }
        System.out.println("Total: " + total);
    }

    public static void shopping() {
        ArrayList<Order> listOrderedByUser = new ArrayList<>();
        if (listFruit.isEmpty()) {
            System.err.println("No item!");
            return;
        }
        displayListFruit();
        Fruit fruit;
        int quantity;
        while (true) {
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(1, listFruit.size());
            fruit = getFruitByItem(item);
            assert fruit != null;
            System.out.println("You select: " + fruit.getName());
            System.out.print("Enter quantity: ");
            quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            System.out.print("Do you want to order now(Y/N): ");
            if (Validation.checkInputYN()) {
                System.out.println("You finished your order!");
                System.out.println("Order details: ");
                System.out.printf("%-20s%-20s%-15s\n", "Fruit name", "Origin", "Price($)");
                System.out.printf("%-20s%-20s%-15.0f\n", fruit.getName(), fruit.getOrigin(), fruit.getPrice());
                listOrderedByUser.add(new Order(fruit.getID(), fruit.getName(), quantity, fruit.getPrice()));
                fruit.setQuantity(fruit.getQuantity() - quantity);
                break;
            } else {
                System.out.print("Do you want to continue buying(Y/N)?: ");
                if (!Validation.checkInputYN()) {
                    return;
                }
            }
        }
        displayListOrder(listOrderedByUser);
        System.out.print("Enter customer's name: ");
        String name = Validation.checkInputString();

//         else {
            try {
                //ArrayList<Order> o = listOrder.get(name);
                listOrder.get(name).addAll(listOrderedByUser);
            } catch (NullPointerException e) {
                listOrder.put(name, listOrderedByUser);
            }
       // }
        System.out.println("Thank you, " + name + "!");
    }

    //If order exists, update order
    static void updateOrder(ArrayList<Order> listOrderedByUser, String ID, int quantity) {
        for (Order order : listOrderedByUser) {
            if (order.getFruitID().equalsIgnoreCase(ID)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }

    public static Fruit getFruitByItem(int item) {
        int countItem = 0;
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem == item) {
                return fruit;
            }
        }
        return null;
    }

    static void displayListFruit() {
        int countItem = 1;
        Collections.sort(listFruit, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.printf("%-10s%-20s%-20s%-15s%-15s\n", "Item", "Fruit name", "Origin", "Price($)", "Quantity");
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-15.0f%-15s\n", countItem++,
                        fruit.getName(), fruit.getOrigin(), fruit.getPrice(), fruit.getQuantity());
            }
        }
    }
}
