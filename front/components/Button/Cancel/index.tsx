import style from './style.module.css';

export interface CancelButtonProps {
  text: string;
  onCancel: (() => void);
}

export const CancelButton = (props: CancelButtonProps) => {

  const { text, onCancel } = props;

  return (
    <button
      onClick={onCancel}
      className={style.button}
      type='button'
    >
      {text}
    </button>
  );
}

export default CancelButton;