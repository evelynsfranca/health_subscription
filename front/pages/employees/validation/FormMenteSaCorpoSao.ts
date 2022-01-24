import { Employee } from "../../../model/Employee";
import {
  validateCpf,
  validateMeditationHours
} from "../../../utils/FormEmployeeValidation";

export const validateFormNMenteSaCorpoSao = (employee: Employee) =>
  validateCpf(employee?.cpf) === true
    && validateMeditationHours(employee?.meditationHours) === true
;