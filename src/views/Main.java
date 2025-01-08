package views;

import java.util.Scanner;
import controllers.CourseController;
import controllers.LearnerController;
import controllers.TopicController;
import interfaces.Manageable;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== Courses Program Management ===");
            System.out.println("1. Manage Topics");
            System.out.println("2. Manage Courses");
            System.out.println("3. Manage Learners");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim(); // Read the input and trim whitespace

            // Validate input
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid option.");
                continue;
            }

            try {
                int option = Integer.parseInt(input);

                switch (option) {
                    case 1:
                        manageItems(new TopicController());
                        break;
                    case 2:
                        manageItems(new CourseController());
                        break;
                    case 3:
                        manageItems(new LearnerController());
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        return;
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric option.");
            }
        }
    }

    private static void manageItems(Manageable controller) {
        while (true) {
            System.out.println("\n--- Manage Items ---");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Display All");
            System.out.println("5. Search");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid option.");
                continue;
            }

            try {
                int option = Integer.parseInt(input);

                switch (option) {
                    case 1:
                        controller.add();
                        break;
                    case 2:
                        System.out.print("Enter the ID to update: ");
                        String updateId = scanner.nextLine().trim();
                        controller.update(updateId);
                        break;
                    case 3:
                        System.out.print("Enter the ID to delete: ");
                        String deleteId = scanner.nextLine().trim();
                        controller.delete(deleteId);
                        break;
                    case 4:
                        controller.displayAll();
                        break;
                    case 5:
                        System.out.print("Enter search query: ");
                        String query = scanner.nextLine().trim();
                        controller.search(query);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid option. Please select a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric option.");
            }
        }
    }
}
