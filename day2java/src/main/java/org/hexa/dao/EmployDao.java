package org.hexa.dao;

import org.hexa.model.Employ;

import java.sql.SQLException;
import java.util.List;

public interface EmployDao {
    List<Employ> showEmployDao() throws SQLException;
    Employ searchEmployDao(int empno) throws SQLException;
    String addEmployDao(Employ employ) throws SQLException;
    String deleteEmployDao(int empno) throws SQLException;
    String updateEmployDao(Employ employ) throws SQLException;
}
