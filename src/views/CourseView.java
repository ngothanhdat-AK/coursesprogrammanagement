package views;

import models.Course;
import java.util.Scanner;

public class CourseView {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayCourse(Course course) {
        System.out.println(course);
    }

    public static void displayCourses(Iterable<Course> courses) {
        for (Course course : courses) {
            displayCourse(course);
        }
    }

public static Course inputCourseData() {
    System.out.print("Enter Course ID: ");
    String courseId = scanner.nextLine().trim();
    
    System.out.print("Enter Course Name: ");
    String name = scanner.nextLine().trim();
    
    System.out.print("Enter Course Type (online/offline): ");
    String type = scanner.nextLine().trim();
    
    System.out.print("Enter Course Title: ");
    String title = scanner.nextLine().trim();
    
    System.out.print("Enter Begin Date (yyyy-MM-dd): ");
    String beginDate = scanner.nextLine().trim();
    
    System.out.print("Enter End Date (yyyy-MM-dd): ");
    String endDate = scanner.nextLine().trim();
    
    System.out.print("Enter Tuition Fee: ");
    double fee = Double.parseDouble(scanner.nextLine().trim());
    
    System.out.print("Enter Topic ID: ");
    String topicId = scanner.nextLine().trim();
    
    return new Course(courseId, name, type, title, beginDate, endDate, fee, topicId);
}

}
