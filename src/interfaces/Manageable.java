package interfaces;

public interface Manageable {
    void add();
    void update(String id);
    void delete(String id);
    void displayAll();
    void search(String query);
}
