
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
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
import { Product } from '../../model/Product';
import style from './style.module.css';

export const NewEmployee = () => {

  const router = useRouter();

  const [loading, setLoading] = useState<boolean>(false);
  const [employee, setEmployee] = useState<Employee>({});
  const [products, setProducts] = useState<Product[]>([]);
  const [clients, setClients] = useState<Client[]>([]);

  async function handleGetAllClients() {
    setLoading(true)
    
    const response: ApiResponse<Client[]> = await getAllClients();

    if (response.entity) {
      setClients(response.entity);
    } else {
      return <div>failed to load</div>
    }

    if(response.status === 200) setLoading(false);
  }
  
  useEffect(() => {
    handleGetAllClients();
  }, []);

  useEffect(() => {
      employee.client && setProducts(employee.client.products);
  }, [employee]);

  async function handleSaveEmployee() {
    setLoading(true)
    
    const response: ApiResponse<Employee> = await saveEmployee(employee);

    if (response.entity) {
      setEmployee(response.entity);
    } else {
      return <div>failed to load</div>
    }

    if(response.status === 200) setLoading(false);
  }

  useEffect(() => console.log("employee", employee), [employee])

  const handleProducts = (id: string) => {
    console.log(id)

    const arr = employee?.products?.filter((item) => item.id !== id);
    
    if(!employee.products.map(it => it.id).includes(id)) {
      setEmployee({ ...employee, products: [...employee?.products, { id: id } ]  })
    } else {
      setEmployee({ ...employee, products: arr  })
    }
  }
  
  return (
    <main className={style.container}>
      <header className={style.header}>
        <h2>Funcionários</h2>
      </header>
      <div>{employee?.id}</div>
      <TextInput
        id="Nome" 
        label="Nome"
        value={employee?.name} 
        onChange={event => setEmployee({...employee, name: event.target.value})}
      
      />

      <SelectInput
        id='client'
        name='client'
        label='Cliente'
        onChange={event => setEmployee({...employee, client: {...employee?.client, id: event.target.value }} )}
        value={employee?.client?.id}
        values={clients}
        defaultValue={employee?.client?.id}
      />

      {employee?.client
        && employee?.client?.id !== '' 
        && products?.length 
        && products?.map(product => (
          <CheckboxInput
            id={product.id} 
            label={product.name} 
            value={product.id} 
            checked={employee.products.map(it => it.id).includes(product.id)}
            onChange={event => handleProducts(event.target.value)}
            key={product.id}
          />
        ))
      }

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
    </main>  
  )

}

export default NewEmployee;