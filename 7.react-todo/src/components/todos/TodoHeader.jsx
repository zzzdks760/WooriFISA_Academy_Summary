import React from 'react'
import TodoFilter from './TodoFilter'

const TodoHeader = () => {
  return (
    <div className="flex items-center justify-between mb-2" id="task-control">
    <button className="px-6 py-2 font-semibold text-gray-100 bg-gray-800 border-none rounded cursor-pointer"
            data-cy="add-todo-button">Add Todo
    </button>
    {/* TodoFilter */}
    <TodoFilter />
    </div>
  )
}

export default TodoHeader