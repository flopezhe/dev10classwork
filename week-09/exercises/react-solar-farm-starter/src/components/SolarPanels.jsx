import React from "react";
import SolarPanel from "./SolarPanel";
import Buttons from "./Buttons";
import { Link } from "react-router-dom";

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

export default function SolarPanels({ setShowForm }){
    return (<>
        <h1 className='mb-3'>Solar Panels</h1>
		<Link className='btn btn-primary mb-3' to='/solarPanels/add'> Add Solar Panel</Link>
        <div className='row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4'>
        {solarPanels.map(solarPanel => (
            <SolarPanel solarPanel={solarPanel} key ={solarPanel.id}/>
        ))}
        </div>
        </>
        );
}