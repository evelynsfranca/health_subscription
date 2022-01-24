
import { useRouter } from 'next/router';
import React from 'react';
import { getAllClients } from '../../api/client';
import { saveEmployee } from '../../api/employee';
import ActionButton from '../../components/Button/Action';
import CancelButton from '../../components/Button/Cancel';
import CheckboxInput from '../../components/Input/Checkbox';
import { TextInput } from '../../components/Input/Text';
import { SelectInput } from '../../components/Select';
import { ApiResponse } from '../../model/ApiResponse';
import { Client } from '../../model/Client';
import { Employee } from '../../model/Employee';
import { PartnerName } from '../../model/enum/PartnerName';
import { Product } from '../../model/Product';
import { validateClient, validateCpf, validateProduct } from '../../utils/FormEmployeeValidation';
import FormManager from './components/form';
import style from './style.module.css';

export const NewEmployee = () => {

  const router = useRouter();

  const [loading, setLoading] = React.useState<boolean>(false);
  const [employee, setEmployee] = React.useState<Employee>(
    { products: [], client: {} }
  );
  const [products, setProducts] = React.useState<Product[]>([]);
  const [clients, setClients] = React.useState<Client[]>([]);
  const [partners, setPartners] = React.useState<PartnerName[]>([]);
  const [showValidation, setShowValidation] = React.useState<boolean>(false);

  const checkedProduct = (productId: string) => employee?.products?.map(it => it.id).includes(productId)

  const handleClient = (clientId: string) => {
    const client: Client = clients.filter(it => it.id == clientId)[0]
    setEmployee(it => ({ ...it, client: client }))
    setProducts(client?.products)
  }

  const handleProducts = (id: string) => {    
    const product: Product = employee?.client?.products?.find(it => it.id == id);
    
    employee?.products?.map(it => it.id).includes(id)
      ? setEmployee({ ...employee, products: employee?.products?.filter((item) => item.id !== id) })
      : setEmployee({ ...employee, products: [...employee?.products, product ]  })
  }

  async function handleGetAllClients() {
    setLoading(true)
    
    const response: ApiResponse<Client[]> = await getAllClients();
    
    response.entity 
      ? setClients(response.entity) 
      : (<div>failed to load</div>)

    response.status === 200 && setLoading(false);
  }

  async function handleSaveEmployee() {    
    // if (!validateForms(employee, partners)) {
    //   setShowValidation(true);
    //   return;
    // } 
    
    setLoading(true)
    
    const response: ApiResponse<Employee> = await saveEmployee(employee);

    response.entity ? setEmployee(response.entity) : (<div>failed to load</div>)
    
    if (response.status === 201) {
       router.back();
    }
    setLoading(false);
  }
  
  React.useEffect(() => { 
    handleGetAllClients() 
    setEmployee({ products: [], client: {} })
  }, []);

  React.useEffect(() => { showValidation && setShowValidation(false) }, [employee]);
  
  
  React.useEffect(() => {
    setPartners(employee?.products?.map(it => it?.partner?.name));
  }, [employee?.products]);

  React.useEffect(() => console.log(employee), [employee])

  return (
    <main className={style.container}>
      <header className={style.header}>
        <h2>Funcionários</h2>
      </header>

      {loading && <>loading</>}
      
      <form className={style.form}>
        <TextInput
          id="cpf" 
          label="CPF"
          value={employee?.cpf} 
          onChange={cpf => setEmployee(it => ({...it, cpf }))}
          validation={showValidation ? validateCpf(employee?.cpf) : ''}
        />

        <SelectInput
          id='client'
          name='client'
          label='Cliente'
          onChange={event => handleClient(event.target.value)}
          value={employee?.client?.id}
          values={clients}
          defaultValue={employee?.client?.id}
          validation={showValidation ? validateClient(employee?.client?.id) : ''}
        />
        <div>
          {products?.length > 0
            && products?.map(product => (
              <CheckboxInput
                id={product.id} 
                label={product.name} 
                value={product.id} 
                checked={checkedProduct(product.id)}
                onChange={event => handleProducts(event.target.value)}
                key={product.id}
              />
            ))
          }
          {showValidation && typeof validateProduct(employee?.products) == 'string'
            && (<span className={style.validationText}>{validateProduct(employee?.products)}</span>)}
        </div>

        <FormManager 
          employee={employee} 
          handleChange={setEmployee} 
          partnersName={partners} 
          showValidation={showValidation}
        />

        <footer className={style.footer}>
          <CancelButton 
            text="CANCELAR"
            onCancel={() => router.back()}
          />
          <ActionButton 
            text="SALVAR"
            onAction={handleSaveEmployee}
          />
        </footer>
      </form>
    </main>  
  )

}

export default NewEmployee;