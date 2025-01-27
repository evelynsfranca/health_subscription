import { useEffect, useState } from "react";
import { getAllProducts } from "../../api/product";
import { ApiResponse } from "../../model/ApiResponse";
import { Product } from "../../model/Product";
import style from './style.module.css';

export const Products = () => {

  const [products, setProducts] = useState<Product[]>([]);
  const [loading, setLoading] = useState<boolean>(false);

  async function handleGetAllProducts() {
    setLoading(true)

    const response: ApiResponse<Product[]> = await getAllProducts();

    if (response.entity) {
      setProducts(response.entity);
    } else {
      return <div>failed to load</div>
    }

    if (response.status === 200) setLoading(false);
  }

  useEffect(() => {
    handleGetAllProducts();
  }, []);

  return (
    <main className={style.container}>

      <header className={style.header}>
        <h2>Produtos</h2>
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

          {products.map(product =>
            <tr key={product.id} className={style.item}>
              <td><span>{product.id}</span></td>
              <td><span>{product.name.replaceAll("_", " ").toLowerCase()}</span></td>
            </tr>
          )}
        </tbody>

      </table>
    </main>
  )

}

export default Products;