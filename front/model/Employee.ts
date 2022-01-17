import { Client } from "./Client";
import { Product } from "./Product";

export interface Employee {
  id?: string;
  name?: string;
  client?: Client;
  products?: Product[];
}