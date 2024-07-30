import { useState } from 'react'
import './App.css'
import AddToDo from './components/AddToDo'
import ToDoItem from './components/ToDoItem'
import ToDoList from './components/ToDoList'

function App() {

  const initialToDos = [
    { id: 1, task: 'Walk the dog', done: true },
    { id: 2, task: 'Laundry', done: false },
    { id: 3, task: 'Dishes ', done: false },
  ];

  const [count, setCount] = useState(0)

  return (
    <>
      <h1>
        <AddToDo />
        <ToDoList tasks={initialToDos}/>
      </h1>
    </>
  )
}

export default App
