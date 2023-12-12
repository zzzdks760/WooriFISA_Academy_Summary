import React, { useState } from 'react'
import TodoItem from './TodoItem';
import { createPortal } from 'react-dom';
import Modal from '../ui/Modal';
import TodoForm from './TodoForm';

const TodoBody = ({todos, onAdd}) => {
  const [data, setData] = useState('');
  const [isOpen, open] = useState(false);
  const openModal = (todoId) => {
    const targetData = todos.find(todo => todo.id === todoId);
    setData(targetData);
    open(true);
  };
  const closeModal = () => open(false);
  return (
    <>
      <ul className='px-0 my-8'>
          {todos.map(todo => <TodoItem todo={todo} key={todo.id} editModal={openModal}/>) }
      </ul>
      {isOpen && createPortal(
        <Modal onClose={closeModal}>
          <TodoForm onAdd={onAdd} onClose={closeModal} data={data}/>
        </Modal>, 
        document.body)
      }
    </>
  )
}

export default TodoBody