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
  if (partners.includes('Norte Europa') && !validateFormNorteEuropa(employee)) return false
  if (partners.includes('Pampulha Intermédica') && !validateFormPampulhaIntermédica(employee)) return false
  if (partners.includes('Dental Sorriso') && !validateFormDentalSorriso(employee)) return false
  if (partners.includes('Mente Sã, Corpo São') && !validateFormNMenteSaCorpoSao(employee)) return false

  return true;
}