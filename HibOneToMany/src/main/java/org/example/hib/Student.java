package org.example.hib;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String qualification;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cid")
    private List<Course> courseList;
}
