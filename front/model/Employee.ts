import { Address } from "./Address";
import { Client } from "./Client";
import { Product } from "./Product";

export interface Employee {
  id?: string;
  name?: string;
  cpf?: string;
  email?: string;
  admissionDate?: Date;
  weight?: string;
  height?: string;
  client?: Client;
  meditationHours?: Number;
  products?: Product[];
  address?: Address;
}