import { useEffect } from "react";
import { getAllClients } from "../api/client";
import { getAllEmployees } from "../api/employee";
import { getAllPartners } from "../api/partner";
import { getAllProducts } from "../api/product";
import { ApiResponse } from "../model/ApiResponse";
import { Client } from "../model/Client";
import { Employee } from "../model/Employee";
import { Partner } from "../model/Partner";
import { Product } from "../model/Product";

export default function Home() {

  async function handleGetAllProducts() {
    const response: ApiResponse<Product[]> = await getAllProducts();

    console.log("products", response)
  }

  async function handleGetAllPartners() {
    const response: ApiResponse<Partner[]> = await getAllPartners();

    console.log("partners", response)
  }

  async function handleGetAllEmployees() {
    const response: ApiResponse<Employee[]> = await getAllEmployees();

    console.log("employees", response)
  }

  async function handleGetAllClients() {
    const response: ApiResponse<Client[]> = await getAllClients();

    console.log("clients", response)
  }




  useEffect(() => {
      handleGetAllProducts();
      handleGetAllPartners();
      handleGetAllEmployees();
      handleGetAllClients();
  }, []);

  return (
    <>Hello</>  
  )
}