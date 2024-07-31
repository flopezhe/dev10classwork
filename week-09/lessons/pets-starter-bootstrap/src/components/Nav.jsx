import { NavLink } from 'react-router-dom';

export default function Nav() {
  return (
    <nav className='navbar navbar-expand'>
      <div className='d-flex'>
        <NavLink className='navbar-brand' to='/'>
          React Pets
        </NavLink>
        <ul className='navbar-nav'>
          <li className='nav-item'>
            <NavLink className='nav-link' to='/'>
              Home
            </NavLink>
          </li>
          <li className='nav-item'>
            <NavLink className='nav-link' to='/pets'>
              Pets
            </NavLink>
          </li>
          <li className='nav-item'>
            <NavLink className='nav-link' to='/about'>
              About
            </NavLink>
          </li>
          <li className='nav-item'>
            <NavLink className='nav-link' to='/'>
              Contact
            </NavLink>
          </li>
          <li className='nav-item'>
            <NavLink className='nav-link' to='/'>
              Sign Up
            </NavLink>
          </li>
          <li className='nav-item'>
            <NavLink className='nav-link' to='/'>
              Log In
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  );
}

  
