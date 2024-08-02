import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import AgentTable from "./AgentTable";

function AgentList() {
  const [agents, setAgents] = useState([]);

  useEffect(() => {
    const fetchAgents = async () => {
      const response = await fetch("http://localhost:8080/api/agent");
      if (response.ok) {
        setAgents(await response.json());
      } else {
        setAgents([]);
      }
    };

    fetchAgents();
  }, []);

  return (
    <>
      {agents.length == 0 ? (
        <div className="alert alert-warning py-4">
          No agents found.
          <br />
          Do you want to add an agent?
        </div>
      ) : (
        <AgentTable agents={agents} />
      )}
      <div className="d-flex flex-grow-1 justify-content-end">
        <Link to="/agents/add" id="btnAdd" className="btn btn-primary">
          Add Agent
        </Link>
      </div>
    </>
  );
}

export default AgentList;
