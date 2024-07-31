import PetCard from './PetCard';
import { Link } from 'react-router-dom';

const pets = [
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
];

export default function PetCards({ setShowForm }) {
	return (
	  <>
		<h1>Pets</h1>
		<Link className='btn btn-primary mb-3' to='/pets/add'>
		Add a Pet
		</Link>
		<div className='row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4'>
		  {pets.map(pet => (
			<PetCard pet={pet} key={pet.id} />
		  ))}
		</div>
	  </>
	);
  }
