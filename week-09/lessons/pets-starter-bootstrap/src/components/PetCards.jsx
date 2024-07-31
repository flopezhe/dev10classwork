import PetCard from './PetCard';
import { Link } from 'react-router-dom';


export default function PetCards({ pets }) {
	return (
		<>
		  <h1>Pets</h1>
		  <Link className='btn btn-primary mb-3' to='/pets/add'>
			Add a Pet
		  </Link>
		  <div className='row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4'>
			{pets.map(pet => (
			  <PetCard pet={pet} key={pet.petId} />
			))}
		  </div>
		</>
	  );
  }
