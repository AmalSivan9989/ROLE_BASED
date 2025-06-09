package org.example.model;

import lombok.*;

import javax.persistence.*;

@NamedQueries(
        @NamedQuery(
                name="validate",
                query="from Login where userName=:userName AND passCode=:passCode"
        )
)

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Login")
public class Login {
    @Id
    private String userName;
    private String passCode;
}
