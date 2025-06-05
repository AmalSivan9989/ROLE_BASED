package org.example.spr;

import java.util.List;

public interface AgentDao {
    List<Agent> showAgents();
    Agent searchAgent(int agentId);
    String addAgent(Agent agent);
    String updateAgent(Agent agent);
    String deleteAgent(int agentId);
}
