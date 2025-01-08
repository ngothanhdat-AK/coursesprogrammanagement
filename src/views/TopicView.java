package views;

import models.Topic;
import java.util.Scanner;

public class TopicView {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayTopic(Topic topic) {
        System.out.println(topic);
    }

    public static void displayTopics(Iterable<Topic> topics) {
        for (Topic topic : topics) {
            displayTopic(topic);
        }
    }

    public static Topic inputTopicData() {
        System.out.print("Enter Topic ID: ");
        String topicId = scanner.nextLine();
        
        System.out.print("Enter Topic Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Topic Type (long/short term): ");
        String type = scanner.nextLine();
        
        System.out.print("Enter Topic Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Topic Duration: ");
        int duration = Integer.parseInt(scanner.nextLine());
        
        return new Topic(topicId, name, type, title, duration);
    }
}
