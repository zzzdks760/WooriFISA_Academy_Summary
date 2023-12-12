import React from 'react'
import { TODO_CATEGORY_ICON } from '@/constants/icon'
import IconButton from '../ui/buttons/IconButton'
import TodoBody from './TodoBody'

// rafce
const TodoItem = ({todo}) => {
  return (
    <li className="flex gap-4 justify-between my-4 py-4 px-4 border-[1px] bg-gray-700 rounded-md shadow-xl">
        <div>
          <span className="text-lg font-medium text-gray-300">{ TODO_CATEGORY_ICON[todo.category]}</span>
            <div>
                <h2 data-test="title" className="mb-0 text-lg font-bold text-gray-100 uppercase">{ todo.title }</h2>
                <p className="mt-2 text-base text-gray-200">{ todo.summary }</p>
            </div>
        </div>
        <div className="flex items-center gap-1">
            <IconButton icon={'✏️'}/>
            <IconButton textColor='text-red-300' icon={'🗑'} />
        </div>
    </li>
  )
}

export default TodoItem