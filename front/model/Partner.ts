import { PartnerName } from "./enum/PartnerName";
import { Product } from "./Product";

export interface Partner {
  id: string;
  name: PartnerName;
  products: Product[];
}