import { Product } from "./Product";

export interface Client {
  id?: string;
  name?: string;
  products?: Product[];
}