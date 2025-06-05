package org.example.spr;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private int qtyOrd;
    private Product product;
}
