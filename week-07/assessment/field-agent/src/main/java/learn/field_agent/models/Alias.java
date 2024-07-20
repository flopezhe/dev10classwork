package learn.field_agent.models;

import java.util.Objects;

public class Alias {

    private int aliasId;
    private String aliasName;
    private String persona;
    private int agentId;

    public Alias(int aliasId, String aliasName, String persona, int agentId) {
        this.aliasId = aliasId;
        this.aliasName = aliasName;
        this.persona = persona;
        this.agentId = agentId;
    }

    public int getAliasId() {
        return aliasId;
    }

    public void setAliasId(int aliasId) {
        this.aliasId = aliasId;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alias alias = (Alias) o;
        return aliasId == alias.aliasId && agentId == alias.agentId && Objects.equals(aliasName, alias.aliasName) && Objects.equals(persona, alias.persona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aliasId, aliasName, persona, agentId);
    }

    @Override
    public String toString() {
        return "Alias{" +
                "aliasId=" + aliasId +
                ", aliasName='" + aliasName + '\'' +
                ", persona='" + persona + '\'' +
                ", agentId=" + agentId +
                '}';
    }
}
