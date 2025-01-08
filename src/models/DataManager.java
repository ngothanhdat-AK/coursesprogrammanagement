package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager<T> implements Serializable {
    
    private final String filename;
    private List<T> data;

    public DataManager(String filename) {
        this.filename = filename;
        this.data = loadData();
    }

    @SuppressWarnings("unchecked")
    private List<T> loadData() {
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                return (List<T>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItem(T item) {
        data.add(item);
        saveData();
    }

    public boolean updateItem(String id, T updatedItem) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).toString().contains(id)) {
                data.set(i, updatedItem);
                saveData();
                return true;
            }
        }
        return false;
    }

    public boolean deleteItem(String id) {
        boolean removed = data.removeIf(item -> item.toString().contains(id));
        if (removed) saveData();
        return removed;
    }

    public List<T> getAll() {
        return data;
    }
}
