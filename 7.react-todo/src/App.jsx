import React, { useState } from 'react'
import DefaultLayout from './layouts/DefaultLayout'
import TodoHeader from './components/todos/TodoHeader'
import TodoBody from './components/todos/TodoBody'

const dummyTodos = [
  {
    id: 1,
    title: 'React 공부',
    summary: 'React를 공부한다.',
    category: 'TODO',
  },
  {
    id: 2,
    title: '점심 먹기',
    summary: '점심을 먹는다.',
    category: 'PROGRESS',
  },
  {
    id: 3,
    title: '커피 마시기',
    summary: '커피를 마신다.',
    category: 'DONE',
  }
]

const App = () => {
  const [todos, setTodos] = useState(dummyTodos);

  const addTodoHandler = ({ title, summary, category }) => {
    const newTodo = {
      id: self.crypto.randomUUID(),
      title,
      summary,
      category
    };

    // ...todos -> {React}, {점심}, {커피..}
    // newTodo -> {새로운 todo 데이터..}
    const updatedTodos = [...todos, newTodo];
    setTodos(updatedTodos);
  }

  const updateTodoHandler = (updateTodo) => {

    // todos = [{React~}, {점심~}, {커피~}]
    // 첫 번째 순회: todo = {React~}  -> updatedTodos - [{Vue공부하기}]
    // 두 번째 순회: todo = {점심~}  -> updatedTodos - [{Vue공부하기}, {점심~}]
    const updatedTodos = todos.map(todo => todo.id === updateTodo.id ? { ...updateTodo } : todo);
    
    setTodos(updatedTodos);
  }

  const deleteTodoHandler = (id) => {
    const filteredTodos = todos.filter(todo => todo.id !== id);
    console.log(filteredTodos);

    setTodos(filteredTodos);
  }

  return (
    <DefaultLayout>
      <div>
        <header>
          <div className="flex justify-center">
            <a to="/">
              <h1 className='py-8 text-red-200 max-w-max text-7xl'>todos</h1>
            </a>
          </div>
        </header>
        <section>
          <TodoHeader onAdd={addTodoHandler}/>
          <TodoBody todos={todos} onUpdate={updateTodoHandler} onDelete={deleteTodoHandler}/>
        </section>
      </div>
    </DefaultLayout>
  )
}

export default App