import React, { useState } from 'react'
import TodoFilter from './TodoFilter'
import Modal from '@/components/ui/Modal';
import { createPortal } from 'react-dom';
import TodoForm from './TodoForm';

const TodoHeader = ({ onAdd }) => {
  const [isOpen, open] = useState(false);
  const openModal = () => open(true);
  const closeModal = () => open(false);

  
  
  return (
    <div className="flex items-center justify-between mb-2" id="task-control">
    <button className="px-6 py-2 font-semibold text-gray-100 bg-gray-800 border-none rounded cursor-pointer"
            data-cy="add-todo-button"
            onClick={openModal}
            >Add Todo
    </button>
    {isOpen && createPortal(
      <Modal onClose={closeModal}>
        {/* <TodoForm onAddOrUpdate={onAdd} onClose={closeModal}/> */}
        <TodoForm onAddOrUpdate={onAdd} onClose={closeModal}>New Todo</TodoForm>
      </Modal>, 
      document.body)}
    <TodoFilter />
    </div>
  )
}

export default TodoHeader