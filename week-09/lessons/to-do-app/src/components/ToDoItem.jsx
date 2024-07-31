import React from 'react'

export default function ToDoItem(props) {


    const task = props.task;
    


  return (
    <>
    <li>
        
        {task.done ? <strike>{task.id}</strike>: task.id },
        {task.done ? <strike>{task.task}</strike>: task.task},
        {task.done ? <strike>DONE</strike> : <button onClick={() => console.log(
        "CLICK"
    )}>
        Click To Complete
    </button>}
        
    </li>
    
    </>
  )
}
