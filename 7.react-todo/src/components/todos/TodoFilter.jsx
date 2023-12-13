import React from 'react'
import { TODO_CATEGORY_ICON } from '@/constants/icon'
import { useTodos, useTodosDispatch } from '@/contexts/TodoContext';

const TodoFilter = () => {

  const todos = useTodos();
  const dispatch = useTodosDispatch();

  return (
    <select className="p-2 text-gray-100 bg-gray-800 rounded"
            data-cy="todo-filter"
            value={todos.category} onChange={(event) => dispatch({ type: 'FILTER', selectedCategory: event.target.value })}
            >
      <option value="ALL">All</option>
      <option value="TODO">{TODO_CATEGORY_ICON.TODO} To do</option>
      <option value="PROGRESS">{TODO_CATEGORY_ICON.PROGRESS} On progress</option>
      <option value="DONE">{TODO_CATEGORY_ICON.DONE} Done</option>
  </select>
  )
}

export default TodoFilter