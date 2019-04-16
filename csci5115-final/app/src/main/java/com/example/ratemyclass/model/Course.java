package com.example.ratemyclass.model;

import android.util.Log;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@IgnoreExtraProperties
public class Course {

//    private List<String> comments;
//    private List<Map<String, String>> links;
//    private List<Long> ratings;

    private List<String> comments = new ArrayList<>();
    private List<Map<String, String>> links = new ArrayList<>();
    private List<Long> ratings = new ArrayList<>();
    private String department;
    private String name;
    private String number;

    public Course() {

    }

    public Course(String department, String name, String number) {
        Log.d("test", "other constructor called: " + comments.toString());
//        this.comments = new ArrayList<String>();
//        this.links = new ArrayList<Map<String, String>>();
//        this.ratings = new ArrayList<Long>();

        this.department = department;
        this.name = name;
        this.number = number;
    }

    public Course(List<String> comments, List<Map<String, String>> links, List<Long> ratings, String department, String name, String number) {
        Log.d("test", "commends added: " + comments.toString());

//        if (comments != null)
//            this.comments = comments;
//        else
//            this.comments = new ArrayList<String>();
//
//        if (links != null)
//            this.links = links;
//        else
//            this.links = new ArrayList<Map<String, String>>();
//
//        if (ratings != null)
//            this.ratings = ratings;
//        else
//            this.ratings = new ArrayList<Long>();

        this.comments = new ArrayList<>(comments);
        this.links = new ArrayList<>(links);
        this.ratings = new ArrayList<>(ratings);

        this.department = department;
        this.name = name;
        this.number = number;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<Map<String, String>> getLinks() {
        return links;
    }

    public void setLinks(List<Map<String, String>> links) {
        this.links = links;
    }

    public List<Long> getRatings() {
        return ratings;
    }

    public void setRatings(List<Long> ratings) {
        this.ratings = ratings;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getAverageRating() {
//        List<Long> ratings = getRatings();
//
//        double sum = 0;
//        for (Long l : ratings)
//            sum += l;
//
//        return sum / ratings.size();

        if (getRatings() != null) {
            List<Long> ratings = getRatings();

            double sum = 0;
            for (Long l : ratings)
                sum += l;

            return sum / ratings.size();
        }
        return 0;
    }

    public String getTitle() {
        return getDepartment() + " " + getNumber();
    }
    public String toString() {
        StringBuffer s = new StringBuffer(getDepartment());
        s.append(" ");
        s.append(getNumber());
        s.append(": ");
        s.append(getName());
        return s.toString();
    }
}
