package org.hexa.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employ {
    private int empno;
    private String name;
    private Gender gender;
    private String dept;
    private String desig;
    private double basic;
}
