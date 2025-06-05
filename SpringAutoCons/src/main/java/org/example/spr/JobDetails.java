package org.example.spr;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobDetails {
    private String job;
    private String company;
    private String location;
}
