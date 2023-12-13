import React, { useState } from 'react'
import { TODO_CATEGORY_ICON } from '@/constants/icon' // src/constants/icon과 동일
import IconButton from '@/components/ui/buttons/IconButton'
import { createPortal } from 'react-dom';
import Modal from '@/components/ui/Modal';
import TodoForm from './TodoForm';

const TodoItem = ({ todo, onUpdate, onDelete }) => {
  const [isOpen, open] = useState(false);
  const openModal = () => open(true);
  const closeModal = () => open(false);

  return (
    <li className="flex gap-4 justify-between my-4 py-4 px-4 border-[1px] bg-gray-700 rounded-md shadow-xl">
        <div>
            <span className="text-lg font-medium text-gray-300">{ TODO_CATEGORY_ICON[todo.category] }</span>
            <div>
                <h2 data-test="title" className="mb-0 text-lg font-bold text-gray-100 uppercase">{ todo.title }</h2>
                <p className="mt-2 text-base text-gray-200">{ todo.summary }</p>
            </div>
        </div>
        <div className="flex items-center gap-1">
            <IconButton onClick={openModal} icon={'✏️'}/>
            <IconButton textColor='text-red-300' 
                        icon={'🗑'} 
                        onClick={() => onDelete(todo.id)} />
        </div>
        {isOpen && createPortal(
          // "Update Todo".startsWith('New') => false
          <Modal onClose={closeModal}>  
            <TodoForm onAddOrUpdate={onUpdate} onClose={closeModal} todo={todo}>Update Todo</TodoForm>
          </Modal>,
          document.body
        )}
    </li>
  )
}

export default TodoItem