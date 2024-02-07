package com.Training.TextToTable.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TrainingDetails")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer Sno;
    private String CourseName;
    private String Resources;
    private String status;
    private String comments;

    public User() {
    }

    public User(Integer sno, String courseName, String resources, String status, String comments){
        Sno = sno;
        CourseName = courseName;
        Resources = resources;
        this.status = status;
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getResources() {
        return Resources;
    }

    public void setResources(String resources) {
        Resources = resources;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}
