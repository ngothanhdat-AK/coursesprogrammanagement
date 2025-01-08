package controllers;

import models.Learner;
import models.Course;
import models.DataManager;
import views.LearnerView;
import views.View;
import interfaces.Manageable;
import java.util.List;
import java.util.stream.Collectors;

public class LearnerController implements Manageable {
    private final DataManager<Learner> learnerManager;
    private final DataManager<Course> courseManager;
    
    public LearnerController() {
        learnerManager = new DataManager<>("learners.dat");
        courseManager = new DataManager<>("courses.dat");
    }

    @Override
    public void add() {
        Learner learner = LearnerView.inputLearnerData();
        Course course = courseManager.getAll().stream()
                .filter(c -> c.getCourseId().equals(learner.getCourseId()))
                .findFirst()
                .orElse(null);

        if (course != null) {
            learnerManager.addItem(learner);
            View.display("Learner added successfully.");
        } else {
            System.out.println("hello");
            View.display("Invalid Course ID. Learner not added.");
        }
    }

    @Override
    public void update(String id) {
        List<Learner> learners = learnerManager.getAll();
        Learner learner = learners.stream().filter(l -> l.getId().equals(id)).findFirst().orElse(null);

        if (learner != null) {
            double score = Double.parseDouble(View.inputText("Enter new score: "));
            learner.updateScore(score);
            learnerManager.updateItem(id, learner);
            View.display("Learner's score updated successfully.");
        } else {
            View.display("Learner not found.");
        }
    }

    @Override
    public void delete(String id) {
        if (learnerManager.deleteItem(id)) {
            View.display("Learner deleted successfully.");
        } else {
            View.display("Learner not found.");
        }
    }

    @Override
    public void displayAll() {
        List<Learner> learners = learnerManager.getAll();
        View.displayList(learners);
    }

    @Override
    public void search(String query) {
        List<Learner> results = learnerManager.getAll().stream()
                .filter(l -> l.getId().contains(query) || l.getName().contains(query))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            View.display("No learners found.");
        } else {
            View.displayList(results);
        }
    }
}
