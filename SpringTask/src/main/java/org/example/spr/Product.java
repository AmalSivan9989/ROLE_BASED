package org.example.spr;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private int quantityAvail;
    private double price;
}
