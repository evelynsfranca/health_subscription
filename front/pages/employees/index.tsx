import { useEffect, useState } from "react";
import { getAllEmployees } from "../../api/employee";
import { LinkButton } from "../../components/Button/Link";
import { ApiResponse } from "../../model/ApiResponse";
import { Employee } from "../../model/Employee";
import style from './style.module.css';

export const Employees = () => {

  const [employees, setEmployees] = useState<Employee[]>([]);
  const [loading, setLoading] = useState<boolean>(false);

  async function handleGetAllEmployees() {
    setLoading(true)

    const response: ApiResponse<Employee[]> = await getAllEmployees();

    if (response.entity) {
      setEmployees(response.entity);
    } else {
      return <div>failed to load</div>
    }

    if (response.status === 200) setLoading(false);
  }

  useEffect(() => {
    handleGetAllEmployees();
  }, []);

  return (
    <main className={style.container}>

      <header className={style.header}>

        <h2>Funcionários</h2>

        <LinkButton
          to="/employees/new"
          text="ADICIONAR"
        />

      </header>

      <table className={style.content}>

        <thead>
          <tr>
            <th>CPF</th>
            <th>Nome</th>
          </tr>
        </thead>

        <tbody>
          {loading && (<tr>Carregando...</tr>)}

          {employees.map(employee =>
            <tr key={employee.id}>
              <td><span>{employee.cpf}</span></td>
              <td><span>{employee.name}</span></td>
            </tr>
          )}
        </tbody>

      </table>
    </main>
  )

}

export default Employees;