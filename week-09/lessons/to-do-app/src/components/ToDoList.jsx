import React from 'react'
import ToDoItem from './ToDoItem';

export default function ToDoList(props) {

    let tasks = props.tasks;

  return (
    <div>
      <h3>TODOLIST</h3>
      <div>
      <ul>
      {tasks.map(task => <ToDoItem task={task} key={task.id} /> )}
      </ul>
      </div>
    </div>
  )
}
