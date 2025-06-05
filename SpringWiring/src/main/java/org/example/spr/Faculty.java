package org.example.spr;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Faculty {
    private String facultyName;
    private List<Student> studentsList;

    public void teaching() {
        System.out.println("Faculty  " + facultyName + " Sharing lunch with Students");
        for (Student student : studentsList) {
            student.display();
        }
    }
}