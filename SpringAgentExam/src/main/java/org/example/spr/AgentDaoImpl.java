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
public class AgentDaoImpl implements AgentDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Agent> showAgents() {
       String cmd="select * from Agent";
       List<Agent> agentList=jdbcTemplate.query(cmd, new RowMapper<Agent>() {
           @Override
           public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
               Agent agent=new Agent();
               agent.setAgentId(rs.getInt("AgentId"));
               agent.setName(rs.getString("Name"));
               agent.setCity(rs.getString("City"));
               agent.setGender(Gender.valueOf(rs.getString("GENDER")));
               agent.setMartialStatus(rs.getInt("MaritalStatus"));
               agent.setPremium(rs.getDouble("Premium"));
               return agent;
           }
       });
       return agentList;
    }

    @Override
    public Agent searchAgent(int agentId) {
      String cmd="select * from Agent where AgentId=?";
        List<Agent> agentList=jdbcTemplate.query(cmd,new Object[]{agentId}, new RowMapper<Agent>() {
            @Override
            public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
                Agent agent=new Agent();
                agent.setAgentId(rs.getInt("AgentId"));
                agent.setName(rs.getString("Name"));
                agent.setCity(rs.getString("City"));
                agent.setGender(Gender.valueOf(rs.getString("GENDER")));
                agent.setMartialStatus(rs.getInt("MaritalStatus"));
                agent.setPremium(rs.getDouble("Premium"));
                return agent;
            }
        });
        if(agentList.size()==0){
            return null;
        }
        return agentList.get(0);
    }

    @Override
    public String addAgent(Agent agent) {
        String cmd="Insert into Agent(AgentId,Name,City,Gender,MaritalStatus,Premium) values(?,?,?,?,?,?)";
        jdbcTemplate.update(cmd,new Object[]{
                agent.getAgentId(),agent.getName(),agent.getCity(),agent.getGender().toString(),agent.getMartialStatus(),agent.getPremium()
        });
        return "Agent Record Inserted";
    }

    @Override
    public String updateAgent(Agent agent) {
        String cmd="update agent set Name=?,City=?,Gender=?,MartialStatus=?,Premium=? where agentId=?";
        jdbcTemplate.update(cmd,new Object[]{
                agent.getAgentId(),agent.getName(),agent.getCity(),agent.getGender().toString(),agent.getMartialStatus(),agent.getPremium()
        });
        return "Agent Record Updated";
    }

    @Override
    public String deleteAgent(int agentId) {
        String cmd="delete from Agent where agentId=?";
        jdbcTemplate.update(cmd,new Object[]{agentId});
        return "Agent Record Deleted";
    }
}
