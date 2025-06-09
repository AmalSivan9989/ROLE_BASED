package org.example.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Employ")
public class Employ {
    @Id
    private int empno;
    private String name;
    private String gender;
    private String dept;
    private String desig;
    private double basic;
}
