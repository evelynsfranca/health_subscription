import Link from 'next/link';
import style from './style.module.css';

export interface LinkButtonProps {
  text: string;
  to: string;
}

export const LinkButton = (props: LinkButtonProps) => {

  const { text, to } = props;

  return (
    <Link href={to}>
      <div className={style.button}>{text}</div>
    </Link>
  );
}

export default LinkButton;