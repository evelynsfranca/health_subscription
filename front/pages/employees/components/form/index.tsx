import React, { Dispatch, SetStateAction } from "react";
import DateInput from "../../../../components/Input/Date";
import TextInput from "../../../../components/Input/Text";
import { Employee } from "../../../../model/Employee";
import { PartnerName } from "../../../../model/enum/PartnerName";
import { validateAdmissionDate, validateCity, validateEmail, validateHeight, validateMeditationHours, validateName, validateNeighborhood, validateNumber, validateState, validateStreet, validateWeight } from "../../../../utils/FormEmployeeValidation";

export interface FormManagerProps {
  partnersName?: PartnerName[];
  employee: Employee;
  handleChange: Dispatch<SetStateAction<Employee>>;
  showValidation?: boolean;
}

export const FormDentalSorrisoFields = ['name', 'height', 'weight'];
export const FormMenteSaCorpoSaoFields = ['meditationHours'];
export const FormNorteEuropaFields = ['name', 'admissionDate', 'email'];
export const FormPampulaIntramedicaFields = ['name', 'street', 'number', 'complement', 'neighborhood', 'city', 'state'];

export const FormManager = (props: FormManagerProps) => {

  const { partnersName, employee, handleChange, showValidation } = props;

  const [activeFields, setActiveFields] = React.useState<string[]>([]);

  React.useEffect(() => {
    setActiveFields([]);

    partnersName?.map(partner => {
      partner == PartnerName.NORTE_EUROPA 
        && setActiveFields(prev => ([...prev, ...FormNorteEuropaFields]));
      partner == PartnerName.PAMPULHA_INTRAMEDICA
        && setActiveFields(prev => ([...prev, ...FormPampulaIntramedicaFields]));
      partner == PartnerName.DENTAL_SORRISO
        && setActiveFields(prev => ([...prev, ...FormDentalSorrisoFields]));
      partner == PartnerName.MENTE_SA_CORPO_SAO
        && setActiveFields(prev => ([...prev, ...FormMenteSaCorpoSaoFields]));
    })

  }, [partnersName]);
  
  return (
    <>
      {activeFields.includes('name') && (
        <TextInput
          id="nome" 
          label="Nome"
          value={employee?.name} 
          onChange={name => handleChange(prev => ({...prev, name }))}
          validation={showValidation && validateName(employee?.name)}
        />
      )}
      {activeFields.includes('admissionDate') && (
        <DateInput
          id="admissionDate" 
          label="Data de Admissão"
          value={employee?.admissionDate?.toString()} 
          onChange={admissionDate => handleChange(prev => ({...prev, admissionDate }))}
          validation={showValidation && validateAdmissionDate(employee?.admissionDate)}
        />
      )}
      {activeFields.includes('email') && (
        <TextInput
          id="email" 
          label="Email"
          value={employee?.email} 
          onChange={email => handleChange(prev => ({...prev, email }))}
          validation={showValidation && validateEmail(employee?.email)}
        />
      )} 
      {activeFields.includes('street') && (  
        <TextInput
          id="street" 
          label="Rua"
          value={employee?.address?.street} 
          onChange={street => handleChange(prev => ({...prev, address: {...prev.address, street } }))}
          validation={showValidation && validateStreet(employee?.address?.street)}
        />
      )}
      {activeFields.includes('number') && (  
        <TextInput
          id="number" 
          label="Número"
          value={employee?.address?.number} 
          onChange={number => handleChange(prev => ({...prev, address: {...prev.address, number } }))}
          validation={showValidation && validateNumber(employee?.address?.number)}
        />
      )}
      {activeFields.includes('complement') && (
        <TextInput
          id="complement" 
          label="Complemento"
          value={employee?.address?.complement} 
          onChange={complement => handleChange(prev => ({...prev, address: {...prev.address, complement } }))}
        />
      )}
      {activeFields.includes('neighborhood') && (  
        <TextInput
          id="neighborhood" 
          label="Bairro"
          value={employee?.address?.neighborhood} 
          onChange={neighborhood => handleChange(prev => ({...prev, address: {...prev.address, neighborhood } }))}
          validation={showValidation && validateNeighborhood(employee?.address?.neighborhood)}
        />
      )}
      {activeFields.includes('city') && (  
        <TextInput
          id="city" 
          label="Cidade"
          value={employee?.address?.city} 
          onChange={city => handleChange(prev => ({...prev, address: {...prev.address, city } }))}
          validation={showValidation && validateCity(employee?.address?.city)}
        />
      )}
      {activeFields.includes('state') && (  
        <TextInput
          id="state" 
          label="Estado"
          value={employee?.address?.state} 
          onChange={state => handleChange(prev => ({...prev, address: {...prev.address, state } }))}
          validation={showValidation && validateState(employee?.address?.state)}
        />
      )}
      {activeFields.includes('height') && (
        <TextInput
          id="height" 
          label="Altura"
          value={employee?.height} 
          onChange={height => handleChange(prev => ({...prev, height }))}
          validation={showValidation && validateHeight(employee?.height)}
        />
      )}
      {activeFields.includes('weight') && (
        <TextInput
          id="weight" 
          label="Peso"
          value={employee?.weight} 
          onChange={weight => handleChange(prev => ({...prev, weight }))}
          validation={showValidation && validateWeight(employee?.weight)}
        />
      )}
      {activeFields.includes('meditationHours') && (
        <TextInput
          id="meditationHours" 
          label="Horas meditadas"
          value={employee?.meditationHours?.toString()} 
          onChange={meditationHours => handleChange(prev => ({...prev, meditationHours }))}
          validation={showValidation && validateMeditationHours(employee?.meditationHours)}
        />
      )}
    </>
  );
}

export default FormManager;