package org.dao;

import org.entity.Employ;

import java.sql.SQLException;
import java.util.List;

public interface EmployDao {
    List<Employ> showEmployDao() throws SQLException;
    Employ searchEmployDao(int empno) throws SQLException;
    String addEmployDao(Employ employ) throws SQLException;
    String deleteEmployDao(int empno) throws SQLException;
    String updateEmployDao(Employ employ) throws SQLException;
    List<Employ> SearchbyDept(String deptName);
    List<Employ> showBySalaryRange( int start, int end) throws SQLException;

}
