package models;

import java.io.Serializable;

public class Learner extends Person implements Serializable {

    private String dob;
    private double score;
    private String courseId;
    
    public Learner(){
        
    }

    public Learner(String learnerId, String name, String dob, double score, String courseId) {
        super(learnerId, name);
        this.dob = dob;
        this.score = score;
        this.courseId = courseId;
    }
    
    public double getScore() {
        return score;
    }

    public void updateScore(double score) {
        this.score = score;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", DOB: " + dob + ", Score: " + score + ", Status: " + (score >= 5 ? "Pass" : "Fail");
    }
}
