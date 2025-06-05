package org.example.spr;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderLogic {
    @Autowired
    private List<Order> items;

    public void displayInfo() {
        for (Order order : items) {
            System.out.println(order);
            int diff = order.getQtyOrd() - order.getProduct().getQuantityAvail();
            if (diff > 0) {
                System.out.println("Insufficient Quantity...");
            } else {
                System.out.println("Total Bill Amount  " + order.getProduct().getPrice() * order.getQtyOrd());
            }
        }
    }
}