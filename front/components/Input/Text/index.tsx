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
  return (
    <div className={style.field}>
      <label htmlFor={props.id} className={style.label}>
        {props.label}
      </label>

      <input 
        id={props.id}
        className={style.input}
        type="text" 
        value={props.value} 
        onChange={event => props.onChange(event.target.value)}
      />

      {typeof props?.validation === 'string'
        && (<span className={style.validationText}>{props?.validation}</span>)
      }
    </div>
  );
}

export default TextInput;