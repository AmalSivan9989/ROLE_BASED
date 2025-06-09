package org.example.model;

import lombok.*;

import javax.persistence.*;

@NamedQueries({


        @NamedQuery(
                name = "showEmploy",
                query ="from Employ"
        ),
        @NamedQuery(
                name="searchEmploy",
                query="from Employ where empno=:empno"
        )}
)
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

