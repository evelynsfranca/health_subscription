import { Employee } from "./Employee";

export interface Address {
  id?: string;
  street?: string;
  number?: string;
  complement?: string;
  neighborhood?: string;
  city?: string;
  state?: string;
  employee?: Employee;
}