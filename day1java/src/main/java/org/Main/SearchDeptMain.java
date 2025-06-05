package org.Main;



import org.dao.EmployDao;
import org.dao.EmployDaoImpl;
import org.entity.Employ;


import java.util.List;
import java.util.Scanner;

public class SearchDeptMain {
    public static void main(String[] args) {
        EmployDao dao = new EmployDaoImpl();
        System.out.print("enter dept name: ");
        Scanner sc=new Scanner(System.in);
        String deptName=sc.next();
        List<Employ> employList = dao.SearchbyDept(deptName);
        employList.forEach(x -> {
            System.out.println(x);
        });
    }
}
