import Link from 'next/link';
import style from './style.module.css';

export const Menu = (props: { currentRoute: string }) => {

  return (
    <header>

      <div>
        <h1 className={style.header}>Health Subscription</h1>
      </div>

      <nav className={style.navbar}>

        <Link href="/clients">
          <div className={`${style.link} ${props.currentRoute == "/clients" ? style.active : ''}`}>
            Clientes
          </div>
        </Link>

        <Link href="/employees">
          <div className={`${style.link} ${props.currentRoute.startsWith("/employees") ? style.active : ''}`}>
            Funcionários
          </div>
        </Link>

        <Link href="/partners">
          <div className={`${style.link} ${props.currentRoute == "/partners" ? style.active : ''}`}>
            Parceiros
          </div>
        </Link>

        <Link href="/products">
          <div className={`${style.link} ${props.currentRoute == "/products" ? style.active : ''}`}>
            Produtos
          </div>
        </Link>
        
      </nav>
    </header>
  );
}

export default Menu;