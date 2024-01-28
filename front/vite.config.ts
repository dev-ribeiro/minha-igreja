import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'
import path from "node:path";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  resolve: {
    alias: {
      "@layouts": path.join(__dirname, "src/layouts"),
      "@pages": path.join(__dirname, "src/pages"),
      "@components": path.join(__dirname, "src/components"),
      "@hooks": path.join(__dirname, "src/hooks"),
      "@models": path.join(__dirname, "src/models"),
      "@to": path.join(__dirname, "src/to")
    }
  }
})
