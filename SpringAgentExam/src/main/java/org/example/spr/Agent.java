package org.example.spr;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class Agent {
    private int agentId;
    private String name;
    private String city;
    private Gender gender;
    private int martialStatus;
    private double premium;

}
