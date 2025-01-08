package models;

import java.io.Serializable;

public abstract class Person implements Serializable {
    protected String id;
    protected String name;
    
    public Person(){
        
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
  
    public String getName() {
        return name;
    }  
    
    public void setName(String name) {
        this.name = name;
    }
    
    public abstract String toString();
}
