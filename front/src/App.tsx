import { Router } from './Router';

import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import { queryClient } from '@libs/query';
import { QueryClientProvider } from '@tanstack/react-query';

export default function App() {

  return (
    <QueryClientProvider client={queryClient}>
      <Router />
    </QueryClientProvider>
  );
}
