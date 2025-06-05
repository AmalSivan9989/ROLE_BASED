package org.example.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HelloImpl implements Hello{
    private String greeting;
    private String welcomeNote;

    private String endNote;


    @Override
    public String sayHello(String name) {

            return greeting+name;
    }

    @Override
    public void sayHello1(String name) {
        System.out.println(welcomeNote);
        System.out.println(greeting+name);
        System.out.println(endNote);
    }
}
