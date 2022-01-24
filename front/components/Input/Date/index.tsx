import React, { SetStateAction } from 'react';
import style from './style.module.css';

export interface DateInputProps {
  id: string;
  value: string;
  label: string;
  onChange: (event: SetStateAction<any>) => void;
  validation?: string | boolean;
}

export const DateInput = (props: DateInputProps) => {

  const inputPattern = /(\d{2})\/(\d{2})\/(\d{4})/;
  const minDate = new Date(1900, 0, 1).toLocaleDateString().replace(inputPattern,'$3-$2-$1');
  const maxDate = new Date(Date.now()).toLocaleDateString().replace(inputPattern,'$3-$2-$1');

  return (
    <div className={style.field}>
      <label htmlFor={props.id} className={style.label}>
        {props.label}
      </label>

      <input 
        id={props.id}
        className={style.input}
        type="date" 
        value={props.value} 
        onChange={event => props.onChange(event.target.value)}
        min={minDate}
        max={maxDate}
      />
      {typeof props?.validation === 'string'
        && (<span className={style.validationText}>{props?.validation}</span>)
      }
    </div>
  );
}

export default DateInput;