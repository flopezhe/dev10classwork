import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

const url = "http://localhost:8080/api/agent";

export default function ConfirmDeleteAgent() {
  const [agent, setAgent] = useState({});

  const { agentId } = useParams();

  const navigate = useNavigate();

  useEffect(() => {
    fetch(`${url}/${agentId}`)
      .then((response) => response.json())
      .then((json) => setAgent(json));
  }, []);

  function handleDelete() {
    fetch(`${url}/${agentId}`, {
      method: "DELETE",
    }).then(navigate("/agents"));
  }

  return (
    <div>
      Are you sure you want to delete this agent?
      <div>First Name: {agent.firstName}</div>
      <div>Middle Name: {agent.middleName}</div>
      <div>Last Name : {agent.lastName}</div>
      <div>Dob : {agent.dob}</div>
      <div>Height: {agent.heightInInches}</div>
      <div>
        <button onClick={handleDelete}>Yes, delete</button>
        <button onClick={() => navigate("/agents")}>No, abort</button>
      </div>
    </div>
  );
}
