package org.example.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/person.xml");
        Person person=(Person) ctx.getBean("person1");
        person.showAllInfo();

        Person person1=(Person) ctx.getBean("person2");
        person1.showAllInfo();
    }
}
