package models;

import java.io.Serializable;

public class Course implements Serializable {

    private String courseId;
    private String name;
    private String type;
    private String title;
    private String beginDate;
    private String endDate;
    private double tuitionFee;
    private String topicId;

    // Constructor
    public Course(){
        
    }
    
    public Course(String courseId, String name, String type, String title, String beginDate, String endDate, double tuitionFee, String topicId) {
        this.courseId = courseId;
        this.name = name;
        this.type = type;
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.tuitionFee = tuitionFee;
        this.topicId = topicId;
    }

    // Getters and Setters

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "ID: " + courseId + ", Name: " + name + ", Type: " + type + ", Title: " + title
                + ", Begin Date: " + beginDate + ", End Date: " + endDate + ", Fee: " + tuitionFee + ", Topic ID: " + topicId;
    }
}
