package org.example.spr;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Getter
@Setter
public class EmployDaoImpl implements EmployDao{
    private JdbcTemplate jdbcTemplate;
    @Override
    public String addEmployDao(Employ employ) {
        return "";
    }

    @Override
    public List<Employ> showEmploydao() {
        String cmd="select * from Employ";
        List<Employ> employList=jdbcTemplate.query(cmd, new RowMapper<Employ>() {
            @Override
            public Employ mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employ employ=new Employ();
                employ.setEmpno(rs.getInt("empno"));
                employ.setName(rs.getString("name"));
                employ.setGender(Gender.valueOf(rs.getString("gender")));
                employ.setDept(rs.getString("dept"));
                employ.setDesig(rs.getString("desig"));
                employ.setBasic(rs.getDouble("basic"));
                return employ;
            }
        });
        return employList;
    }

    @Override
    public Employ searchEmployDao(int empno) {
       String cmd="select * from Employ where empno=?";
       List<Employ> employList=jdbcTemplate.query(cmd, new Object[]{empno}, new RowMapper<Employ>() {
           @Override
           public Employ mapRow(ResultSet rs, int rowNum) throws SQLException {
               Employ employ=new Employ();
               employ.setEmpno(rs.getInt("empno"));
               employ.setName(rs.getString("name"));
               employ.setGender(Gender.valueOf(rs.getString("gender")));
               employ.setDept(rs.getString("dept"));
               employ.setDesig(rs.getString("desig"));
               employ.setBasic(rs.getDouble("basic"));
               return employ;
           }
       });
       if (employList.size()==0){
           return null;
       }
       return employList.get(0);
    }

    @Override
    public String updateEmployDao(Employ employ) {
        String cmd="update employ set Name=?,Gender=?,Dept=?,Desig=?,Basic=? where Empno=?";
        jdbcTemplate.update(cmd,new Object[]{employ.getName(), employ.getGender().toString(),
                employ.getDept(), employ.getDesig(), employ.getBasic(), employ.getEmpno()});
        return "Employ Record Updated...";
    }

    @Override
    public String deleteEmployDao(int empno) {
       String cmd="delete from Employ where empno=?";
       jdbcTemplate.update(cmd,new Object[]{empno});
       return "Employ Record Updated...";
    }
}
