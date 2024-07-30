import React from "react";
import SolarPanel from "./SolarPanel";

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

export default function SolarPanels(){
    return (<main>
        <h1 className='mb-3'>Solar Panels</h1>
        <button className='mb-3 btn btn-primary'>
            Add Solar Panel
        </button>
        {solarPanels.map(solarPanel => (
            <SolarPanel solarPanel={solarPanel} key ={solarPanel.solarPanelId}/>
        ))}
        
    </main>);
}