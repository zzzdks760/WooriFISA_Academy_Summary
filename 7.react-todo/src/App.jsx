import DefaultLayout from "@/layouts/DefaultLayout"
import TodoBody from "@/components/todos/TodoBody"
import TodoHeader from "@/components/todos/TodoHeader"
import { TodoProvider } from "@/contexts/TodoContext"

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
        <TodoProvider>
          <TodoHeader />
          <TodoBody />
        </TodoProvider>
        </section>
      </div>
    </DefaultLayout>
  )
}

export default App