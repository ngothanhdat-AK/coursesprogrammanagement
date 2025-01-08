package views;

import models.Learner;
import java.util.Scanner;

public class LearnerView {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayLearner(Learner learner) {
        System.out.println(learner);
    }

    public static void displayLearners(Iterable<Learner> learners) {
        for (Learner learner : learners) {
            displayLearner(learner);
        }
    }

    public static Learner inputLearnerData() {
        System.out.print("Enter Learner ID: ");
        String learnerId = scanner.nextLine();
        
        System.out.print("Enter Learner Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        String dob = scanner.nextLine();
        
        System.out.print("Enter Score: ");
        double score = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        
        return new Learner(learnerId, name, dob, score, courseId);
    }
}
