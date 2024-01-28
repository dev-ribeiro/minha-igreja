import { ReactNode } from 'react';
import { Link as RLink } from 'react-router-dom';

type Props = {
  children: ReactNode;
  path: string;
}

export function Link({ children, path }: Props) {

  return (
    <RLink to={path}>
      {children}
    </RLink>
  );
}
