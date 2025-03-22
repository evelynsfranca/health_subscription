import { API_TOKEN, API_URL } from "../constants";
import { ApiResponse } from "../model/ApiResponse";
import { Product } from "../model/Product";

export const saveProduct = async (product: Product): Promise<ApiResponse<Product>> => {
  
  const apiResponse: ApiResponse<Product> = {}

  const res = await fetch(`${API_URL}/products`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
            "Authorization": API_TOKEN
    },
    body: JSON.stringify(product)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const updateProduct = async (product: Product): Promise<ApiResponse<Product>> => {
  
  const apiResponse: ApiResponse<Product> = {}

  const res = await fetch(`${API_URL}/products`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
            "Authorization": API_TOKEN
    },
    body: JSON.stringify(product)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const getProduct = async (id: String): Promise<ApiResponse<Product>> => {
  
  const apiResponse: ApiResponse<Product> = {}

  const res = await fetch(`${API_URL}/products/${id}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
            "Authorization": API_TOKEN
    }
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const getAllProducts = async (): Promise<ApiResponse<Product[]>> => {
  
  const apiResponse: ApiResponse<Product[]> = {}

  const res = await fetch(`${API_URL}/products`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
            "Authorization": API_TOKEN
    }
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const deleteProduct = async (id: String): Promise<ApiResponse<Product>> => {
  
  const apiResponse: ApiResponse<Product> = {}

  const res = await fetch(`${API_URL}/products/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
      "Authorization": API_TOKEN
    }
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}