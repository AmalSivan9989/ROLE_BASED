package org.example.spr;

import java.util.List;

public interface EmployDao {
    List<Employ> showEmploydao();
    Employ searchEmployDao(int empno);
    String addEmployDao(Employ employ);
    String updateEmployDao(Employ employ);
    String deleteEmployDao(int empno);

}
