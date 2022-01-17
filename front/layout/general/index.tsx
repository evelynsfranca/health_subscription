import Head from 'next/head';
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
import Menu from '../../components/Menu';
import style from './style.module.css';

export const GeneralLayout = ({ children }) => {

  const router = useRouter();

  const [currentRoute, setCurrentRoute] = useState<string>("");

  useEffect(() => {
    if(router.pathname != currentRoute) {
      setCurrentRoute(router.pathname);
    }
  }, [router.pathname]);


  return (
    <>
      <Head>
        <title>
          {currentRoute.startsWith('/clients') ? 'Clientes ' : ''}
          {currentRoute.startsWith('/products') ? 'Produtos ' : ''}
          {currentRoute.startsWith('/employees') ? 'Funcionários ' : ''}
          {currentRoute.startsWith('/partners') ? 'Parceiros' : ''}

          - Pipo Saúde
        </title>
      </Head>
      <div className={style.page}>
        <Menu currentRoute={currentRoute} />
        {children}
      </div>
    </>
  );
}

export default GeneralLayout;