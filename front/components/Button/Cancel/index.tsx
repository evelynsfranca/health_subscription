import style from './style.module.css';

export interface CancelButtonProps {
  text: string;
  onCancel: (() => void);
}

export const CancelButton = (props: CancelButtonProps) => {
  return (
    <button
      onClick={props.onCancel} 
      className={style.button}
      type='button'
    >
      {props.text}
    </button>
  );
}

export default CancelButton;