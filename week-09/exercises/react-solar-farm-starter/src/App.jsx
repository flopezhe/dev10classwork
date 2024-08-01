import Header from "./components/Header";
// import { useState } from 'react';
import SolarPanels from "./components/SolarPanels";
import AddForm from "./components/AddForm";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import NotFound from "./components/NotFound";
import "bootstrap/dist/css/bootstrap.css";

function App() {
  // const[showForm, setShowForm] = useState(false);

  // return (
  // 	<div className='container'>
  // 		<Header />
  // 		{showForm === true ? (<AddForm setShowForm={setShowForm}/>
  // 	) : (<SolarPanels setShowForm={setShowForm}/>)}

  // 	</div>
  // );

  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/Home" element={<Home />} />
        <Route path="/solarPanels/add" element={<AddForm />} />
        <Route path="/solarPanels" element={<SolarPanels />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  );
}
import Home from "./components/Home";

export default App;
