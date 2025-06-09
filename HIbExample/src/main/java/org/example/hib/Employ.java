package org.example.hib;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employ")
@ToString
public class Employ {
    @Id
    private int empno;
    private String name;
    private String gender;
    private String dept;
    private String desig;
    private double basic;

}
