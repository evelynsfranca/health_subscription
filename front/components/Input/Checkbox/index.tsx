import { SetStateAction } from 'react';
import style from './style.module.css';

export interface CheckboxInputProps {
  id: string;
  value: string;
  label: string;
  checked: boolean;
  onChange: (event: SetStateAction<any>) => void;
  validation?: string | boolean;
}

export const CheckboxInput = (props: CheckboxInputProps) => {
  return (
    <div className={style.field}>
      <div className={style.container}>
        <label htmlFor={props.id} className={style.label}>{props.label}</label>
        <input 
          id={props.id} 
          className={style.input}
          type="checkbox" 
          value={props.value} 
          checked={props.checked}
          onChange={props.onChange} 
        />
        <span className={style.checkmark}></span>
      </div>
      {typeof props?.validation === 'string'
        && (<span className={style.validationText}>{props?.validation}</span>)
      }
    </div>
  );
}

export default CheckboxInput;