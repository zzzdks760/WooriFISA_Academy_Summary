import React from 'react'
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
          <TodoHeader />
          <TodoBody todos = {dummyTodos}/>
        </section>
      </div>
    </DefaultLayout>
  )
}

export default App