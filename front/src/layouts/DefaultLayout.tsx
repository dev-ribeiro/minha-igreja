import { Link } from "@components/Link";
import { Outlet } from "react-router-dom";

export function DefaultLayout() {

  return (
    <div className="flex">
      <aside className="flex-[1]">
        <div className="flex flex-col">
          <h2>Cadastro</h2>
          <Link path="/cadastro/congregacao">Congregação</Link>
          <span>Membros</span>
        </div>
      </aside>
      <div className="flex-[4]">
        <Outlet />
      </div>
    </div>
  );
}
