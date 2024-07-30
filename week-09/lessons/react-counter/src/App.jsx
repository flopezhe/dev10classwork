import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {

  let count = 0;

  const[currentCount, setCount] = useState(0);

  return (
    <div className='App'>
      <h1>{currentCount}</h1>
      <div>
        <button onClick={()=> setCount(count => count + 1)}>+</button>
        <button onClick={()=> setCount(count => count - 1)}>-</button>
      </div>
    </div>
  );
}

export default App
