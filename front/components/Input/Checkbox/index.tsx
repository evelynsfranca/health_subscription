import { SetStateAction } from 'react';
import style from './style.module.css';

export interface CheckboxInputProps {
  id: string;
  value: string;
  label: string;
  checked: boolean;
  onChange: (event: SetStateAction<any>) => void;
}

export const CheckboxInput = (props: CheckboxInputProps) => {
  return (
    <div className={style.field}>
      <div className={style.container}>
        <label htmlFor={props.id}>{props.label}</label>
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
    </div>
  );
}

export default CheckboxInput;