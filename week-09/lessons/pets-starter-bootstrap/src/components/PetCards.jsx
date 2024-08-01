import { useState, useEffect } from "react";
import React from "react";
import { Link } from "react-router-dom";

import PetCard from "./PetCard";

export default function PetCards() {
  // Destructure pets out of props

  const [pets, setPets] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/pets") // Make a `GET` request for pets to our backend
      .then((res) => res.json()) // Read the body stream to completion
      .then(setPets) // Put the body in pets state (shorthand for .then(res => setPets(res)))
      .catch(console.error);
  }, []);

  return (
    <>
      <h1>Pets</h1>
      <Link className="btn btn-primary mb-3" to="/pets/add">
        Add a Pet
      </Link>
      <div className="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        {pets.map((pet) => (
          <PetCard pet={pet} key={pet.petId} />
        ))}
      </div>
    </>
  );
}
