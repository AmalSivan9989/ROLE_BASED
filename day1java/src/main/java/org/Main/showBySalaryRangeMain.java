package org.Main;

import org.dao.EmployDao;
import org.dao.EmployDaoImpl;
import org.entity.Employ;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class showBySalaryRangeMain {
    public static void main(String[] args) throws SQLException {
        EmployDao dao = new EmployDaoImpl();
      //  Scanner sc=new Scanner(System.in);
       // String deptName=sc.next();
        List<Employ> employList = dao.showBySalaryRange(50000,90000);
        employList.forEach(x -> {
            System.out.println(x);
        });
    }
}
