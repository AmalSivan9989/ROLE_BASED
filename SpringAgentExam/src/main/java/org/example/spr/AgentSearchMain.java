package org.example.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class AgentSearchMain {
    public static void main(String[] args) {
        int agentId;
        Scanner sc=new Scanner(System.in);
        System.out.print("enter agent id: ");
        agentId=sc.nextInt();
        ApplicationContext ctx=new ClassPathXmlApplicationContext("org/example/spr/agent.xml");
        AgentDao dao=(AgentDaoImpl)ctx.getBean("agentDaoImpl");
        Agent agent=dao.searchAgent(agentId);
        if(agent!=null){
            System.out.println(agent);
        }
        else{
            System.out.println("record not found..");
        }
    }
}
