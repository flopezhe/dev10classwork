import React from "react";
import { NavLink } from "react-router-dom";

function Nav() {
  return (
    <>
      <nav className="navbar navbar-expand-lg">
        <div className="collapse navbar-collapse">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item">
              <NavLink id="linkHome" to="/home" className="nav-link">
                Home
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink id="linkAgents" to="/agents" className="nav-link">
                Agents
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink id="linkAgencies" to="/agencies" className="nav-link">
                Agencies
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink id="linkAbout" to="/about" className="nav-link">
                About
              </NavLink>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
}

export default Nav;
