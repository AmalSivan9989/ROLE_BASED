package org.example.dao;
import org.example.model.Employ;
import org.example.model.Login;

import java.util.List;

public interface EmployDao {
    List<Employ> showEmployDao();
    Employ searchEmployDao(int empno);
    String addUser(Login login);
    Long authenticate(Login login);
}
