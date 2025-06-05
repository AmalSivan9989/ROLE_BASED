package org.dao;

import org.entity.Gender;

import org.entity.Employ;
import org.util.ConnectionHelper;

import javax.swing.text.html.Option;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EmployDaoImpl implements EmployDao{



    static Connection connection;
    PreparedStatement psmt;
    static{
        try{
            connection= ConnectionHelper.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String deleteEmployDao(int empno) throws SQLException {
        Optional<Employ>employFound=Optional.ofNullable(searchEmployDao(empno));
        if(employFound.isPresent()){
            String cmd="delete from Employ where empno=?";
            psmt= connection.prepareStatement(cmd);
            psmt.setInt(1,empno);
            psmt.executeUpdate();
            return "employ record deleted...";

        }
        return "employ record not found...";
    }

    @Override
    public String updateEmployDao(Employ employ) throws SQLException {
        Optional<Employ>employFound=Optional.ofNullable(searchEmployDao(employ.getEmpno()));
        if(employFound.isPresent()){
            String cmd="update Employ set Name=?,Gender=?,Dept=?,Desig=?,Basic=? where Empno=?";
            psmt= connection.prepareStatement(cmd);
            psmt.setString(1,employ.getName());
            psmt.setString(2,employ.getGender().toString());
            psmt.setString(3,employ.getDept());
            psmt.setString(4, employ.getDesig());
            psmt.setDouble(5,employ.getBasic());
            psmt.setInt(6,employ.getEmpno());
            psmt.executeUpdate();
            return "employ record updated...";


        }
        return "employ record not found...";
    }

    @Override
    public Employ searchEmployDao(int empno) throws SQLException {
        String cmd="select * from employ where empno=?";
        psmt=connection.prepareStatement(cmd);
        psmt.setInt(1,empno);
        ResultSet rs=psmt.executeQuery();
        Employ employ=null;
        if(rs.next()){
            employ = new Employ();
            employ.setEmpno(rs.getInt("empno"));
            employ.setName(rs.getString("name"));
            employ.setGender(Gender.valueOf(rs.getString("gender")));
            employ.setDept(rs.getString("dept"));
            employ.setDesig(rs.getString("desig"));
            employ.setBasic(rs.getDouble("basic"));
        }
        return employ;

    }

    @Override
    public String addEmployDao(Employ employ) throws SQLException {
        String cmd="insert into Employ(empno,name,gender,dept,desig,basic) values(?,?,?,?,?,?)";
        psmt= connection.prepareStatement(cmd);
        psmt.setInt(1,employ.getEmpno());
        psmt.setString(2,employ.getName());
        psmt.setString(3,employ.getGender().toString());
        psmt.setString(4,employ.getDept());
        psmt.setString(5,employ.getDesig());
        psmt.setDouble(6,employ.getBasic());
        psmt.executeUpdate();
        return "employ record inserted...";
    }

    @Override
    public List<Employ> showEmployDao() throws SQLException {
        String cmd="select * from Employ";
        psmt=connection.prepareStatement(cmd);
        ResultSet rs= psmt.executeQuery();
        Employ employ=null;
        List<Employ> employList=new ArrayList<Employ>();
        while(rs.next()){
            employ=new Employ();
            employ = new Employ();
            employ.setEmpno(rs.getInt("empno"));
            employ.setName(rs.getString("name"));
            employ.setGender(Gender.valueOf(rs.getString("gender")));
            employ.setDept(rs.getString("dept"));
            employ.setDesig(rs.getString("desig"));
            employ.setBasic(rs.getDouble("basic"));
            employList.add(employ);

        }
        return employList;
    }


    @Override
    public List<Employ> SearchbyDept(String deptName) {
        List<Employ>  employList = null;
        try {
            employList = showEmployDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Employ> res1=new ArrayList<Employ>();
        Stream<Employ> filter=employList.stream().filter(x->x.getDept().equals(deptName));
        filter.forEach(x->{
            res1.add(x);
        });



    return res1;
    }

    @Override
    public List<Employ> showBySalaryRange(int start, int end) throws SQLException {
        List<Employ>  employList1 = null;
        try {
            employList1 = showEmployDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Employ> res=new ArrayList<Employ>();
        Stream<Employ> filter=employList1.stream().filter(x->x.getBasic() >= start && x.getBasic() <= end);
        filter.forEach(x->{
            res.add(x);
        });
        return res;

    }
}
