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

  const { id, label, checked, value, onChange, validation } = props;

  return (
    <div className={style.field}>

      <div className={style.container}>

        <label
          htmlFor={id}
          className={style.label}
        >
          <span>{label}</span>

          <input
            id={id}
            className={style.input}
            type="checkbox"
            value={value}
            checked={checked}
            onChange={onChange}
          />

          <span className={style.checkmark} />

        </label>

      </div>

      {typeof validation === 'string' && (
        <span className={style.validationText}>
          {validation}
        </span>
      )}
    </div>
  );
}

export default CheckboxInput;