import { useEffect, useState } from "react";
import { getAllPartners } from "../../api/partner";
import { ApiResponse } from "../../model/ApiResponse";
import { Partner } from "../../model/Partner";
import style from './style.module.css';

export const Partners = () => {

  const [partners, setPartners] = useState<Partner[]>([]);
  const [loading, setLoading] = useState<boolean>(false);

  async function handleGetAllPartners() {
    setLoading(true)

    const response: ApiResponse<Partner[]> = await getAllPartners();

    if (response.entity) {
      setPartners(response.entity);
    } else {
      return <div>failed to load</div>
    }

    if (response.status === 200) setLoading(false);
  }

  useEffect(() => {
    handleGetAllPartners();
  }, []);

  return (
    <main className={style.container}>

      <header className={style.header}>
        <h2>Parceiros</h2>
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

          {partners.map(partner =>
            <tr key={partner.id} className={style.item}>
              <td><span>{partner.id}</span></td>
              <td><span><span>{partner.name.replaceAll("_", " ").toLowerCase()}</span></span></td>
            </tr>
          )}
        </tbody>

      </table>
    </main>
  )

}

export default Partners;