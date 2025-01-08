package controllers;

import models.Topic;
import models.DataManager;
import views.TopicView;
import views.View;
import interfaces.Manageable;
import java.util.List;
import java.util.stream.Collectors;

public class TopicController implements Manageable {
    private DataManager<Topic> dataManager;

    public TopicController() {
        dataManager = new DataManager<>("topics.dat");
    }

    @Override
    public void add() {
        Topic topic = TopicView.inputTopicData();
        dataManager.addItem(topic);
        View.display("Topic added successfully.");
    }

    @Override
    public void update(String id) {
        Topic existingTopic = dataManager.getAll().stream()
                .filter(t -> t.getTopicId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingTopic != null) {
            Topic updatedTopic = TopicView.inputTopicData();
            dataManager.updateItem(id, updatedTopic);
            View.display("Topic updated successfully.");
        } else {
            View.display("Topic not found.");
        }
    }

    @Override
    public void delete(String id) {
        if (dataManager.deleteItem(id)) {
            View.display("Topic deleted successfully.");
        } else {
            View.display("Topic not found.");
        }
    }

    @Override
    public void displayAll() {
        List<Topic> topics = dataManager.getAll();
        topics.sort((t1, t2) -> t1.getName().compareTo(t2.getName()));
        View.displayList(topics);
    }

    @Override
    public void search(String query) {
        List<Topic> results = dataManager.getAll().stream()
                .filter(t -> t.getTopicId().contains(query) || t.getName().contains(query))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            View.display("No topics found.");
        } else {
            View.displayList(results);
        }
    }
}
