import { SetStateAction } from 'react';
import style from './style.module.css';

export interface TextInputProps {
  id: string;
  value: string;
  label: string;
  onChange: (event: SetStateAction<any>) => void;
  validation?: string | boolean;
}

export const TextInput = (props: TextInputProps) => {

  const { id, label, value, onChange, validation } = props;

  return (
    <div className={style.field}>

      <label
        htmlFor={id}
        className={style.label}
      >
        {label}
      </label>

      <input
        id={id}
        className={style.input}
        type="text"
        value={value}
        onChange={event => onChange(event.target.value)}
      />

      {typeof validation === 'string' && (
        <span className={style.validationText}>{validation}</span>
      )}
    </div>
  );
}

export default TextInput;