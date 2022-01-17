import GeneralLayout from '../layout/general';
import '../styles/global.css';

export default ({ Component }) => {
  return (
    <GeneralLayout>
      <Component />
    </GeneralLayout>
  )
}