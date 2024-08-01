import { NavLink } from "react-router-dom";

const NavBar = () => {
  return (
    <ul>
      <NavLink activeClassName="active" to="/list">
        View Games
      </NavLink>
      <NavLink activeClassName="active" to="/form">
        Add a Game
      </NavLink>
    </ul>
  );
};

export default NavBar;
