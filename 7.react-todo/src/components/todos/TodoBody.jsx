import React from 'react'
import TodoItem from './TodoItem';

const todos = [1,2,3];
const TodoBody = () => {
  return (
    <ul className='px-0 my-8'>
        {todos.map((todo,index) => <TodoItem key={index}/>) }
    </ul>
  )
}

export default TodoBody