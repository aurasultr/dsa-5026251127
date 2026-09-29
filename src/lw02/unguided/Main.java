package lw02.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(
            Main.class.getResourceAsStream("orders.txt")
        );

        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> successful = new LinkedList<>();

        Queue<String[]> process = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while (sc.hasNext()) {

            String[] order = new String[4];

            order[0] = sc.next(); // name
            order[1] = sc.next(); // food
            order[2] = sc.next(); // drink
            order[3] = sc.next(); // table number

            orders.add(order);
        }
        foods.add(new String[]{"Bakso", "2"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});

        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});

        process.addAll(orders);

        while (!process.isEmpty()) {
            String[] order = process.poll();
            String food = order[1];
            String drink = order[2];

            boolean foodAvailable = true;
            boolean drinkAvailable = true;

            if (!food.equals("-")) {
                for (String[] data : foods) {
                    if (data[0].equals(food)) {
                        int stock = Integer.parseInt(data[1]);
                        if (stock <= 0) {
                            foodAvailable = false;
                        }
                        break;
                    }
                }
            }
            if (!drink.equals("-")) {
                for (String[] data : drinks) {
                    if (data[0].equals(drink)) {
                        int stock = Integer.parseInt(data[1]);
                        if (stock <= 0) {
                            drinkAvailable = false;
                        }
                        break;
                    }
                }
            }
            if (foodAvailable && drinkAvailable) {
                if (!food.equals("-")) {
                    for (String[] data : foods) {
                        if (data[0].equals(food)) {
                            int stock = Integer.parseInt(data[1]);
                            stock--;
                            data[1] = String.valueOf(stock);
                            break;
                        }
                    }
                }
                if (!drink.equals("-")) {
                    for (String[] data : drinks) {
                        if (data[0].equals(drink)) {
                            int stock = Integer.parseInt(data[1]);
                            stock--;
                            data[1] = String.valueOf(stock);
                            break;
                        }
                    }
                }
                successful.add(order);
            } else {
                failed.push(order);
            }
        }
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : successful) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
        System.out.println("=== Remaining Food Stock ===");
        for (String[] data : foods) {
            System.out.println(data[0] + " : " + data[1]);
        }
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] data : drinks) {
            System.out.println(data[0] + " : " + data[1]);
        }
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}