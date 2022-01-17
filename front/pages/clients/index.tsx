import { useEffect, useState } from "react";
import { getAllClients } from "../../api/client";
import { ApiResponse } from "../../model/ApiResponse";
import { Client } from "../../model/Client";
import style from './style.module.css';

export const Clients = () => {

  const [clients, setClients] = useState<Client[]>([]);
  const [loading, setLoading] = useState<boolean>(false);

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

  return (
    <main className={style.container}>
      <header className={style.header}>
        <h2>Clientes</h2>
      </header>

      <table className={style.content}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
          </tr>
        </thead>
        <tbody>
          {loading && (<tr>Carregando...</tr>)}
          {clients.map(client => 
            <tr key={client.id} >
              <td>{client.id}</td>
              <td>{client.name}</td>
            </tr>
          )}
        </tbody>
      </table>
    </main>  
  )

}

export default Clients;