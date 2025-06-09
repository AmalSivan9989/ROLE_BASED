package org.example.main;

import org.example.dao.EmployDao;
import org.example.dao.EmployDaoImpl;
import org.example.model.Employ;

import java.util.Scanner;

public class EmploySearchMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employ Number  ");
        int empno=sc.nextInt();
        EmployDao employDao=new EmployDaoImpl();
        Employ employ=employDao.searchEmployDao(empno);
        if(employ!=null){
            System.out.println(employ);
        }
    }
}
