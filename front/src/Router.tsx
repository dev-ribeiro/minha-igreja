import { DefaultLayout } from "@layouts/DefaultLayout";
import { Home } from "@pages/Home";
import { Congregation } from "@pages/Congregation";
import { BrowserRouter, Route, Routes } from "react-router-dom";

export function Router() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<DefaultLayout />}>
          <Route path="/" element={<Home />} />
          <Route path="/cadastro/congregacao" element={<Congregation />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
