package org.example.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployShowMain {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/jdbc.xml");
        EmployDao dao=(EmployDao)ctx.getBean("EmployDaoImpl");
        List<Employ> employList=dao.showEmploydao();
        for(Employ employ:employList){

            System.out.println(employ);

        }

    }
}
