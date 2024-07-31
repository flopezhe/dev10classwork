// import { useState } from 'react'; // No longer needed, remove!
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Add this!

import NotFound from './components/NotFound';
import Header from './components/Header';
import PetCards from './components/PetCards';
import PetForm from './components/PetForm';

const initialPets = [
  {
		petId: 1,
		name: 'Wishbone',
		type: 'DOG',
		breed: 'Jack Russell Terrier',
		dob: '2015-05-05',
		adopted: true,
		vaccinationStatus: 'UNKNOWN',
		imageUrl: 'https://i.imgur.com/yGzjvPj.jpg',
	},
	{
		petId: 2,
		name: 'Whiskers',
		type: 'CAT',
		breed: 'Tabby',
		dob: '2020-01-01',
		adopted: false,
		vaccinationStatus: 'UP_TO_DATE',
		imageUrl: 'https://i.imgur.com/vlnDvGW.jpg',
	},
	{
		petId: 3,
		name: 'Archie',
		type: 'DOG',
		breed: 'Golden Retriever',
		dob: '2022-12-15',
		adopted: false,
		vaccinationStatus: 'NOT_UP_TO_DATE',
		imageUrl: 'https://i.imgur.com/IeR2bMU.jpg',
	},
]

function App() {
  // const [showForm, setShowForm] = useState(false); // No longer needed, remove!
  const [pets, setPets] = useState(initialPets);

  function handleAdd(newPet) {
    // 2. Spread original pets, add in new pet from form
    setPets([...pets, newPet]);
  }
  // Delete the enclosing div
  return (
    <Router>
      {/* 1. Wrap all components in <Router> */}
      <Header /> {/* 2. Components that always live on the page and use React Router elements */}
      <Routes>
        {/* 3. <Routes> contains all the individual Route components*/}
        <Route path='/pets' element={<PetCards pets={pets}/>} />
        <Route path='/pets/add' element={<PetForm handleAdd={handleAdd}/>} />
		<Route path='*' element={<NotFound />} />
      </Routes>
    </Router>
  );
}

export default App
