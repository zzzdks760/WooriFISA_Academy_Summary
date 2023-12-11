import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: [
      //@로 작성할 경우 /src로 대체되도록
      {find: '@', replacement: '/src'}
    ]
  }
})
