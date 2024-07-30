
import Header from './components/Header';
import { useState } from 'react';
import SolarPanels from './components/SolarPanels';
import AddForm from './components/AddForm';


function App() {

	const[showForm, setShowForm] = useState(false);

	return (
		<div className='container'>
			<Header />
			{showForm === true ? (<AddForm />
		) : (<SolarPanels setShowForm={setShowForm}/>)}
			
		</div>
	);
}


export default App
