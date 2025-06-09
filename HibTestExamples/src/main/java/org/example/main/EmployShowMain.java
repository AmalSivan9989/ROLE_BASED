package org.example.main;

import org.example.dao.EmployDao;
import org.example.dao.EmployDaoImpl;
import org.example.model.Employ;

import java.util.List;

public class EmployShowMain {
    public static void main(String[] args) {
        EmployDao employDao=new EmployDaoImpl();
        List<Employ> employList=employDao.showEmployDao();
        for(Employ employ:employList){
            System.out.println(employ);
        }
    }
}
