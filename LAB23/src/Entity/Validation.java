package Entity;

import java.util.ArrayList;
import java.util.Scanner;

import static Entity.Manager.listFruit;
import static Entity.Manager.listOrder;

public class Validation {
    private static Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        //String result;
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Do not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputFruitID(String fruitID) {
        if (!checkIdExist(fruitID)) {
            System.err.println("Fruit with ID exist!");
            return false;
        }
        return true;
    }

    //check user input int
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input double
    public static double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    //check user input yes/ no
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    //check id exist
    public static boolean checkIdExist( String id) {
        for (Fruit fruit : listFruit) {
            if (id.equalsIgnoreCase(fruit.getID())) {
                return false;
            }
        }
        return true;
    }
    //check item exist or not
    public static boolean checkItemExist(ArrayList<Order> listOrderedByUser, String ID) {
        for (Order order : listOrderedByUser) {
            if (order.getFruitID().equalsIgnoreCase(ID)) {
                return true;
            }
        }
        return false;
    }
}
