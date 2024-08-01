import { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";

import "./App.css";
import NavBar from "./components/NavBar";
import GameList from "./components/GameList";
import GameForm from "./components/GameForm";

function App() {
  return (
    <BrowserRouter>
      <div>
        <h1>Welcome to Board Game Library!</h1>
        <NavBar />

        <Routes>
          <Route path="/list" element={<GameList />} />
          <Route path="/form" element={<GameForm />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
