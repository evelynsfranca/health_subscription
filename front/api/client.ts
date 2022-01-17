import { API_URL } from "../constants";
import { ApiResponse } from "../model/ApiResponse";
import { Client } from "../model/Client";

export const saveClient = async (client: Client): Promise<ApiResponse<Client>> => {
  
  const apiResponse: ApiResponse<Client> = {}

  const res = await fetch(`${API_URL}/clients`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(client)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const updateClient = async (client: Client): Promise<ApiResponse<Client>> => {
  
  const apiResponse: ApiResponse<Client> = {}

  const res = await fetch(`${API_URL}/clients`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(client)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const getClient = async (id: String): Promise<ApiResponse<Client>> => {
  
  const apiResponse: ApiResponse<Client> = {}

  const res = await fetch(`${API_URL}/clients/${id}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
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

export const getAllClients = async (): Promise<ApiResponse<Client[]>> => {
  
  const apiResponse: ApiResponse<Client[]> = {}

  const res = await fetch(`${API_URL}/clients`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json"
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

export const deleteClient = async (id: String): Promise<ApiResponse<Client>> => {
  
  const apiResponse: ApiResponse<Client> = {}

  const res = await fetch(`${API_URL}/clients/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json"
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