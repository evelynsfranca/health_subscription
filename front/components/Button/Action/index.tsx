import style from './style.module.css';

export interface ActionButtonProps {
  text: string;
  onAction: () => void;
}

export const ActionButton = (props: ActionButtonProps) => {
  return (
    <button
      onClick={props.onAction} 
      className={style.button}
    >
      {props.text}
    </button>
  );
}

export default ActionButton;