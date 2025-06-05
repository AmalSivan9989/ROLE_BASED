package org.example.spr;

import org.example.dao.NameImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainProg4 {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/hello.xml");
        NameImpl nameImpl =(NameImpl)ctx.getBean("nameBean1");
        System.out.println(nameImpl.fullName());

        NameImpl obj = (NameImpl)ctx.getBean("nameBean2");
        System.out.println(obj.fullName());

    }
}
