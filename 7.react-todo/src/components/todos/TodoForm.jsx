import React, { useEffect, useState } from 'react'
import { TODO_CATEGORY_ICON } from '@/constants/icon'
import { enteredTodoFormIsNotEmpty } from '@/utils/utils';

const TodoForm = ({ onAddOrUpdate, onClose, children, todo }) => {

    const isNewTodoForm = (children) => children.startsWith('New') ? true : false

    const [title, setTitle] = useState(isNewTodoForm(children) ? '' : todo.title);
    const [summary, setSummary] = useState(isNewTodoForm(children) ? '' : todo.summary);
    const [category, setCategory] = useState(isNewTodoForm(children) ? '' : todo.category);
    const [isFormInvalid, setInvalid] = useState(true);

    const addOrUpdateTodoHandler = () => {
        // onAdd({ title, summary, category });

        // 조건에 따라 addTodo를 호출할지, updateTodo를 호출할지 분기
        if (isNewTodoForm(children)) {
            onAddOrUpdate({ title, summary, category }) // addTodo 호출
        } else {
            // updateTodo 호출
            const updateTodo = {
                id: todo.id,
                title,
                summary,
                category
            }

            onAddOrUpdate(updateTodo);
        }

        onClose();
    }

    useEffect(() => {
        if (enteredTodoFormIsNotEmpty(title, summary)) {
            setInvalid(false);
        } else {
            setInvalid(true);
        }
    }, [title, summary]);

  return (
    <>
            <h3 className="text-3xl text-red-200">New Todo</h3>
            <form className='my-2'>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='title'>Title</label>
                    <input className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded' 
                           type='text' id='title' value={title} onChange={event => setTitle(event.target.value)} />
                </div>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='summary'>Summary</label>
                    <textarea className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded' 
                              id='summary' rows='5' value={summary} onChange={event => setSummary(event.target.value)}/>
                </div>
                <div>
                    <label className='block mb-2 text-xl text-white' htmlFor='category'>Category</label>
                    <select className='w-full p-2 border-[1px] border-gray-300 bg-gray-200 text-gray-900 rounded' 
                            id='category' value={category} onChange={event => setCategory(event.target.value)} >

                        <option value='TODO'>{TODO_CATEGORY_ICON.TODO} To do</option>
                        <option value='PROGRESS'>{TODO_CATEGORY_ICON.PROGRESS} On progress</option>
                        <option value='DONE'>{TODO_CATEGORY_ICON.DONE} Done</option>
                    </select>
                </div>
                {isFormInvalid && <div className='mt-2 text-red-500'>모든 항목을 채워서 작성해주세요</div>}
                
                <div className='flex justify-end gap-4'>
                    <button className='text-xl text-white' type='button' onClick={onClose}>Cancel</button>
                    <button className='px-6 py-3 text-xl text-red-200' type='button' onClick={addOrUpdateTodoHandler} disabled={isFormInvalid}>
                        {isNewTodoForm(children) ? 'Add' : 'Update'}
                    </button>
                </div>
            </form>
        </>
  )
}

export default TodoForm