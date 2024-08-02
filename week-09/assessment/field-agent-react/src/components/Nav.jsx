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
              <a
                id="linkAgencies"
                href="#"
                className="nav-link"
                onClick={(evt) => evt.preventDefault()}
              >
                Agencies
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </>
  );
}

export default Nav;
