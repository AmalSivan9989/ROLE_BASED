package org.example.dao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NameImpl implements Name{
    private String firstName;
    private String lastName;
    @Override
    public String fullName() {
        return firstName+" "+lastName;
    }
}
