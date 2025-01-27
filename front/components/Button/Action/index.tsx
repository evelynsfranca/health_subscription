import style from './style.module.css';

export interface ActionButtonProps {
  text: string;
  onAction: () => void;
}

export const ActionButton = (props: ActionButtonProps) => {

  const { text, onAction } = props;

  return (
    <button
      onClick={onAction}
      className={style.button}
      type='button'
    >
      {text}
    </button>
  );
}

export default ActionButton;