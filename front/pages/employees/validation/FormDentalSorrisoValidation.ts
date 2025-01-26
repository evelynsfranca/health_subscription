import { Employee } from "../../../model/Employee";
import {
  validateCpf,
  validateHeight,
  validateName,
  validateWeight
} from "../../../utils/FormEmployeeValidation";

export const validateFormDentalSorriso = (employee: Employee) =>
  validateCpf(employee?.cpf) === true
    && validateName(employee?.name) === true
    && validateHeight(employee?.height) === true
    && validateWeight(employee?.weight) === true
;

export default validateFormDentalSorriso;