package org.example.main;

import org.example.dao.EmployDao;
import org.example.dao.EmployDaoImpl;
import org.example.model.Login;

import java.util.Scanner;

public class AddUserMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Login login=new Login();
        System.out.println("enter user name");
        login.setUserName(sc.next());
        System.out.println("enter password");
        login.setPassCode(sc.next());
        EmployDao employDao=new EmployDaoImpl();
        System.out.println(employDao.addUser(login));
    }
}
