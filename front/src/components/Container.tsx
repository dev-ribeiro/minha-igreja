import { ReactNode } from "react"

type Props = {
  children: ReactNode;
}

export function Container({ children }: Props) {

  return <main className="px-3 pt-2">{children}</main>;
}
