package org.example.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/order.xml");
        OrderLogic order=(OrderLogic) ctx.getBean("orderLogic");
        order.displayInfo();
    }
}
