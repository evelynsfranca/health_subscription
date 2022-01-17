import Link from 'next/link';
import style from './style.module.css';

export interface LinkButtonProps {
  text: string;
  to: string;
}

export const LinkButton = (props: LinkButtonProps) => {
  return (
    <Link href={props.to}>
      <div className={style.button}>{props.text}</div>
    </Link>
  );
}

export default LinkButton;