import React from 'react'
import DefaultLayout from './layouts/DefaultLayout'
import TodoHeader from './components/todos/TodoHeader'
import TodoBody from './components/todos/TodoBody'

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
          <TodoBody />
        </section>
      </div>
    </DefaultLayout>
  )
}

export default App