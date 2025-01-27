import { Employee } from "../../../model/Employee";
import { validateClient, validatePartners, validateProduct } from "../../../utils/FormEmployeeValidation";
import { validateFormDentalSorriso } from "./FormDentalSorrisoValidation";
import { validateFormNMenteSaCorpoSao } from "./FormMenteSaCorpoSao";
import { validateFormNorteEuropa } from "./FormNorteEuropaValidation";
import { validateFormPampulhaIntermédica } from "./FormPampulhaIntermédicaValidation";

export const validateForms = (employee: Employee, partners?: string[]): boolean => {

  if (validateClient(employee?.client?.id) != true) return false
  if (validateProduct(employee?.products) != true) return false
  if (partners === undefined || validatePartners(partners) != true) return false
  if (partners.includes('NORTE_EUROPA') && !validateFormNorteEuropa(employee)) return false
  if (partners.includes('PAMPULHA_INTRAMEDICA') && !validateFormPampulhaIntermédica(employee)) return false
  if (partners.includes('DENTAL_SORRISO') && !validateFormDentalSorriso(employee)) return false
  if (partners.includes('MENTE_SA_CORPO_SAO') && !validateFormNMenteSaCorpoSao(employee)) return false

  return true;
}

export default validateForms;