package org.example.spr;

import org.example.dao.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg3 {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/hello.xml");
        Hello hello=(Hello)ctx.getBean("beanHello");
        hello.sayHello1("amal");
        hello.sayHello1("sivan");
    }
}
