import React from "react";
import logo from '../assets/logo.png';
import { Link } from "react-router-dom";

export default function Header(){
    return(
        <header className='mb-3'>
				<nav className='navbar navbar-expand'>
					<div className='d-flex'>
						<a className='navbar-brand' href='/'>
							<img src={logo} alt='Solar Farm' width='150' />
						</a>
						<ul className='navbar-nav'>
							<li className='nav-item'>
								<Link className='nav-link ' to='/Home'>
									Home
								</Link>
							</li>
							<li className='nav-item'>
								<Link className='nav-link' to='/solarPanels'>
									Solar Panels
								</Link>
							</li>
							<li className='nav-item'>
								<Link className='nav-link' to='/'>
									Contact
								</Link>
							</li>
						</ul>
					</div>
				</nav>
			</header>
    );
}