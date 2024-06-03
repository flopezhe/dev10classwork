import logo from './assets/logo.png';

const solarPanels = [
	{
		id: 17,
		section: 'The Ridge',
		row: 1,
		column: 1,
		yearInstalled: 2020,
		material: 'POLY_SI',
		tracking: true,
	},
	{
		id: 18,
		section: 'The Ridge',
		row: 1,
		column: 2,
		yearInstalled: 2021,
		material: 'CIGS',
		tracking: true,
	},
	{
		id: 19,
		section: 'Flats',
		row: 1,
		column: 1,
		yearInstalled: 2020,
		material: 'CD_TE',
		tracking: false,
	},
];

function App() {
	return (
		<div className='container'>
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
			<main>
				<h1 className='mb-3'>Solar Panels</h1>
				<button className='mb-3 btn btn-primary'>
					Add Solar Panel
				</button>
				<table className='table table-striped'>
					<thead>
						<tr>
							<th>Section</th>
							<th>Row</th>
							<th>Column</th>
							<th>Year Installed</th>
							<th>Material</th>
							<th>Tracking Software</th>
							<th>Modify</th>
						</tr>
					</thead>
					<tbody>
						{solarPanels.map(solarPanel => (
							<tr key={solarPanel.id}>
								<td>{solarPanel.section}</td>
								<td>{solarPanel.row}</td>
								<td>{solarPanel.column}</td>
								<td>{solarPanel.yearInstalled}</td>
								<td>{solarPanel.material}</td>
								<td>{solarPanel.tracking ? 'Yes' : 'No'}</td>
								<td>
									<button className='btn btn-warning me-2 mb-2'>
										Edit
									</button>
									<button className='btn btn-danger'>
										Delete
									</button>
								</td>
							</tr>
						))}
					</tbody>
				</table>
			</main>
		</div>
	);
}


export default App
