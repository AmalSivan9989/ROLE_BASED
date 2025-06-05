package org.hexa.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private int custId;
    private String customerName;
    private String city;
    private String mobile;
}
