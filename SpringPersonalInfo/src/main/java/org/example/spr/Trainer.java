package org.example.spr;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Trainer {
    private String trainerName;
    private String location;
    private List<Student> studentList;

    public void showInfo() {
        System.out.println("Trainer Name  " + trainerName);
        System.out.println("Location  " + location);
        System.out.println("Students List is  ");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}