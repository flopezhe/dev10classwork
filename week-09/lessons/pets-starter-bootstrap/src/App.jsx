// import { useState } from 'react'; // No longer needed, remove!
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; // Add this!

import NotFound from './components/NotFound';
import Header from './components/Header';
import PetCards from './components/PetCards';
import PetForm from './components/PetForm';

function App() {
  // const [showForm, setShowForm] = useState(false); // No longer needed, remove!

  // Delete the enclosing div
  return (
    <Router>
      {/* 1. Wrap all components in <Router> */}
      <Header /> {/* 2. Components that always live on the page and use React Router elements */}
      <Routes>
        {/* 3. <Routes> contains all the individual Route components*/}
        <Route path='/pets' element={<PetCards />} />
        <Route path='/pets/add' element={<PetForm />} />
		<Route path='*' element={<NotFound />} />
      </Routes>
    </Router>
  );
}

export default App
