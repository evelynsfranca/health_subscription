import { API_TOKEN, API_URL } from "../constants";
import { ApiResponse } from "../model/ApiResponse";
import { Employee } from "../model/Employee";

export const saveEmployee = async (employee: Employee): Promise<ApiResponse<Employee>> => {

  const apiResponse: ApiResponse<Employee> = {}

  const res = await fetch(`${API_URL}/employees`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Authorization": API_TOKEN
    },
    body: JSON.stringify(employee)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

  apiResponse.entity = res;

  return apiResponse;
}

export const updateEmployee = async (employee: Employee): Promise<ApiResponse<Employee>> => {

  const apiResponse: ApiResponse<Employee> = {}

  const res = await fetch(`${API_URL}/employees`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      "Authorization": API_TOKEN
    },
    body: JSON.stringify(employee)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

  apiResponse.entity = res;

  return apiResponse;
}

export const getEmployee = async (id: String): Promise<ApiResponse<Employee>> => {

  const apiResponse: ApiResponse<Employee> = {}

  const res = await fetch(`${API_URL}/employees/${id}`, {
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

export const getAllEmployees = async (): Promise<ApiResponse<Employee[]>> => {

  const apiResponse: ApiResponse<Employee[]> = {}

  const res = await fetch(`${API_URL}/employees`, {
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

export const deleteEmployee = async (id: String): Promise<ApiResponse<Employee>> => {

  const apiResponse: ApiResponse<Employee> = {}

  const res = await fetch(`${API_URL}/employees/${id}`, {
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