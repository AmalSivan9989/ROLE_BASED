package org.example.main;

import org.example.dao.EmployDao;
import org.example.dao.EmployDaoImpl;
import org.example.model.Employ;

import java.util.Scanner;

public class EmployAddMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employ employ = new Employ();
        System.out.println("Enter Employ Number  ");
        employ.setEmpno(sc.nextInt());
        System.out.println("Enter Employ Name  ");
        employ.setName(sc.next());
        System.out.println("Enter Gender  ");
        employ.setGender(sc.next());
        System.out.println("Enter Department  ");
        employ.setDept(sc.next());
        System.out.println("Enter Designation  ");
        employ.setDesig(sc.next());
        System.out.println("Enter Basic  ");
        employ.setBasic(sc.nextDouble());
        EmployDao employDao=new EmployDaoImpl();
        System.out.println(employDao.addEmployDao(employ));

    }
}