import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AgentForm from "./components/AgentForm";
import AgentList from "./components/AgentList";
import Landing from "./components/Landing";
import Nav from "./components/Nav";
import NotFound from "./components/NotFound";
import ConfirmDeleteAgent from "./components/ConfirmDeleteAgent";

const componentMap = {
  form: AgentForm,
  list: AgentList,
  landing: Landing,
};

function App() {
  // TODO: Implement React Router V6.

  // TODO: Add routes for update and delete.

  // TODO: Add a ConfirmAgentDelete component that renders with the delete route.
  // The delete route should contain an agent id.
  // Use that id to fetch a single agent, display their name,
  // and then either delete or cancel.
  // If the agent isn't found. Redirect to the AgentList route.

  return (
    <Router>
      <main className="container">
        <Nav />
        <Routes>
          <Route path="/home" element={<Landing />} />
          <Route path="/agents/add" element={<AgentForm />} />
          <Route path="/agents/edit/:agentId" element={<AgentForm />} />
          <Route
            path="/agents/delete/:agentId"
            element={<ConfirmDeleteAgent />}
          />
          <Route path="/agents" element={<AgentList />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </main>
    </Router>
  );
}

export default App;
