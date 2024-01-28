import { ReactNode } from "react"

type Props = {
  children: ReactNode;
}

export function Container({ children }: Props) {

  return <main>{children}</main>;
}
