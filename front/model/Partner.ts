import { Product } from "./Product";

export interface Partner {
  id: string;
  name: string;
  products: Product[];
}