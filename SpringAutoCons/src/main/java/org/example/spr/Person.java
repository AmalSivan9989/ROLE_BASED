package org.example.spr;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private Family family;
    @Autowired
    private JobDetails jobDetails;

    public void showAllInfo(){
        System.out.println(family);
        System.out.println(jobDetails);
        System.out.println("Id  " +id+ " Name  " +name);
    }
}
