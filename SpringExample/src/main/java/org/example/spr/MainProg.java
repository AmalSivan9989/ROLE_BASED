package org.example.spr;

import org.example.dao.HelloImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/hello.xml");
        HelloImpl obj=(HelloImpl) ctx.getBean("bean1");
        System.out.println(obj.sayHello("amal"));
    }
}
