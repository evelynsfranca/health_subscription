import { Employee } from "../../../model/Employee";
import {
  validateAdmissionDate,
  validateCity,
  validateCpf,
  validateName,
  validateNeighborhood,
  validateNumber,
  validateState,
  validateStreet
} from "../../../utils/FormEmployeeValidation";

export const validateFormPampulhaIntermédica = (employee: Employee) =>
  validateCpf(employee?.cpf) === true
    && validateName(employee?.name) === true
    && validateAdmissionDate(employee?.admissionDate) === true

    && validateStreet(employee?.address.street) === true
    && validateNumber(employee?.address.number) === true
    && validateNeighborhood(employee?.address.neighborhood) === true
    && validateCity(employee?.address.city) === true
    && validateState(employee?.address.state) === true
;
