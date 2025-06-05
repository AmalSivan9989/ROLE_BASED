package org.example.spr;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    @Autowired
    private JobDetails jobDetails;
    private Family family;

    public void showAllInfo() {
        System.out.println(family);
        System.out.println(jobDetails);
        System.out.println("Id  " +id+ " Name  " +name);
    }

}
