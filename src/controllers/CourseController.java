// controllers/CourseController.java
package controllers;

import models.Course;
import models.DataManager;
import views.CourseView;
import views.View;
import interfaces.Manageable;
import java.util.List;
import java.util.stream.Collectors;

public class CourseController implements Manageable {
    private final DataManager<Course> dataManager;

    public CourseController() {
        dataManager = new DataManager<>("courses.dat");
    }

    @Override
    public void add() {
        Course course = CourseView.inputCourseData();
        dataManager.addItem(course);
        View.display("Course added successfully.");
    }

    @Override
    public void update(String id) {
        Course existingCourse = dataManager.getAll().stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingCourse != null) {
            Course updatedCourse = CourseView.inputCourseData();
            dataManager.updateItem(id, updatedCourse);
            View.display("Course updated successfully.");
        } else {
            View.display("Course not found.");
        }
    }

    @Override
    public void delete(String id) {
        if (dataManager.deleteItem(id)) {
            View.display("Course deleted successfully.");
        } else {
            View.display("Course not found.");
        }
    }

    @Override
    public void displayAll() {
        List<Course> courses = dataManager.getAll();
        courses.sort((c1, c2) -> c1.getBeginDate().compareTo(c2.getBeginDate()));
        View.displayList(courses);
    }

    @Override
    public void search(String query) {
        List<Course> results = dataManager.getAll().stream()
                .filter(c -> c.getCourseId().contains(query) || c.getName().contains(query))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            View.display("No courses found.");
        } else {
            View.displayList(results);
        }
    }
}
