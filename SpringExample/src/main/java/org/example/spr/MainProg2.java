package org.example.spr;

import org.example.dao.Hello;
import org.example.dao.HelloImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MainProg2 {
    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("org/example/spr/hello.xml");
        Hello hello = null;
        Date date = new Date();
        int hr = date.getHours();
        if(hr<12){
            hello=(HelloImpl)ctx.getBean("bean2");
        }
        if (hr >=12 && hr < 16) {
            hello = (HelloImpl)ctx.getBean("bean3");
        }
        if (hr >= 16) {
            hello = (HelloImpl)ctx.getBean("bean4");
        }
        System.out.println(hello.sayHello("Amal"));
    }
}