package org.example.main;

import org.example.dao.EmployDao;
import org.example.dao.EmployDaoImpl;
import org.example.model.Employ;

import java.util.Scanner;

public class EmployDeleteMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter employ number ");
        int empno=sc.nextInt();
        EmployDao employDao=new EmployDaoImpl();
        System.out.println(employDao.deleteEmployDao(empno));
    }
}
