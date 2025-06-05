package org.entity;

import lombok.*;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Employ {
    private int empno;
    private String name;
    private Gender gender;
    private String dept;
    private String desig;
    private double basic;

}
