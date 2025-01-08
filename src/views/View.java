package views;

import java.util.List;

public class View {
    public static void display(String message) {
        System.out.println(message);
    }

    public static String inputText(String prompt) {
        System.out.print(prompt);
        return new java.util.Scanner(System.in).nextLine();
    }

    public static void displayList(List<?> items) {
        if (items.isEmpty()) {
            System.out.println("No items to display.");
        } else {
            for (Object item : items) {
                System.out.println(item);
            }
        }
    }
}
