import React from "react";
import logo from '../assets/logo.png';

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
								<a className='nav-link ' href='/'>
									Home
								</a>
							</li>
							<li className='nav-item'>
								<a className='nav-link' href='/'>
									About
								</a>
							</li>
							<li className='nav-item'>
								<a className='nav-link' href='/'>
									Contact
								</a>
							</li>
						</ul>
					</div>
				</nav>
			</header>
    );
}