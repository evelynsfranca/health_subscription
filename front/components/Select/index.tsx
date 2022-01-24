import { SetStateAction } from 'react';
import style from './style.module.css';

export interface SelectInputProps<T> {
  id: string;
  value: string;
  label: string;
  defaultValue: string;
  values: T[];
  name: string;
  onChange: (event: SetStateAction<T>) => void;
  validation?: string | boolean;
}

export const SelectInput = (props: SelectInputProps<any>) => {
  return (
    <div className={style.field}>
      <label htmlFor={props.id} className={style.label}>
        {props.label}
      </label>

      <select
        name={props.name}
        className={style.select}
        value={props.value}
        defaultValue={props.defaultValue}
        onChange={props.onChange}
      >
        <option value=""></option>
          {props.values?.map(value => (
            <option 
              key={value.id} 
              value={value?.id ?? ""} 
              className={style.option}
            >
              {value?.name ?? ""}
            </option>
        ))}
      </select>
      {typeof props?.validation === 'string'
        && (<span className={style.validationText}>{props?.validation}</span>)
      }
    </div>
  );
}

export default SelectInput;