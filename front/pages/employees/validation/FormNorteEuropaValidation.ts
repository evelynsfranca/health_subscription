import { Employee } from "../../../model/Employee";
import {
  validateAdmissionDate,
  validateCpf,
  validateEmail,
  validateName
} from "../../../utils/FormEmployeeValidation";

export const validateFormNorteEuropa = (employee: Employee) =>
  validateCpf(employee?.cpf) === true
    && validateName(employee?.name) === true
    && validateEmail(employee?.email) === true
    && validateAdmissionDate(employee?.admissionDate) === true
;
export default validateFormNorteEuropa;