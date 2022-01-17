import { Partner } from "./Partner";
import { ProductCategory } from "./ProductCategory";

export interface Product {
  id: string;
  name?: string;
  category?: ProductCategory;  
  partner?: Partner;
}