import { Product } from "../model/Product";
import { isNotBlank } from "./StringValidation";

export const validateClient = (clientId?: string) => 
  isNotBlank(clientId) ? true : "Selecione um cliente";

export const validateProduct = (products?: Product[]) => 
  products && products?.length && isNotBlank(products[0]?.id) ? true : "Selecione um produto";

export const validatePartners = (partners?: string[]) => 
  partners?.length > 0 ? true : "Selecione um produto";

export const validateCpf = (cpf?: string) => 
  isNotBlank(cpf) ? true : "CPF obrigatório";

export const validateName = (name?: string) => 
  isNotBlank(name) ? true : "Nome obrigatório";

export const validateEmail = (email?: string) => 
  isNotBlank(email) ? true : "E-mail obrigatório";

export const validateAdmissionDate = (admissionDate?: Date) => 
  admissionDate ? true : "Data de admissão obrigatório";

export const validateHeight = (height?: string) => 
  isNotBlank(height) ? true : "Altura obrigatória";
  
export const validateWeight = (weight?: string) => 
  isNotBlank(weight) ? true : "Peso obrigatório";

export const validateMeditationHours = (meditationHours?: Number) =>
  meditationHours ? true : "Tempo de meditação obrigatório";

export const validateStreet = (street?: string) => 
  isNotBlank(street) ? true : "Rua obrigatória";

export const validateNumber = (number?: string) => 
  isNotBlank(number) ? true : "Número obrigatória";

export const validateNeighborhood = (neighborhood?: string) => 
  isNotBlank(neighborhood) ? true : "Bairro obrigatório";

export const validateCity = (city?: string) => 
  isNotBlank(city) ? true : "Cidade obrigatória";

export const validateState = (state?: string) => 
  isNotBlank(state) ? true : "Estado obrigatório";