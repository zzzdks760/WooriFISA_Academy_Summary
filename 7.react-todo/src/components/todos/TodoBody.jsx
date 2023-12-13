import React from 'react'
import TodoItem from './TodoItem';
import { useTodos } from '@/contexts/TodoContext'

const TodoBody = () => {
  const todos = useTodos();
  const filterTodos = (todos, selectedCategory) => selectedCategory === 'ALL' ? todos : todos.filter(todo => todo.category === selectedCategory);
  const filteredTodos = filterTodos(todos.data, todos.category);

  return (
    <ul className='px-0 my-8'>
      {filteredTodos.map((todo,index) => <TodoItem todo={todo} key={index}/>)}
    </ul>
  )
}

export default TodoBody