import { API_URL } from "../constants";
import { ApiResponse } from "../model/ApiResponse";
import { Partner } from "../model/Partner";

export const savePartner = async (partner: Partner): Promise<ApiResponse<Partner>> => {
  
  const apiResponse: ApiResponse<Partner> = {}

  const res = await fetch(`${API_URL}/partners`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(partner)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const updatePartner = async (partner: Partner): Promise<ApiResponse<Partner>> => {
  
  const apiResponse: ApiResponse<Partner> = {}

  const res = await fetch(`${API_URL}/partners`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(partner)
  })
    .then(res => {
      apiResponse.status = res.status;
      return res.json();
    })
    .catch(e => console.warn(e));

    apiResponse.entity = res;

  return apiResponse;
}

export const getPartner = async (id: String): Promise<ApiResponse<Partner>> => {
  
  const apiResponse: ApiResponse<Partner> = {}

  const res = await fetch(`${API_URL}/partners/${id}`, {
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

export const getAllPartners = async (): Promise<ApiResponse<Partner[]>> => {
  
  const apiResponse: ApiResponse<Partner[]> = {}

  const res = await fetch(`${API_URL}/partners`, {
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

export const deletePartner = async (id: String): Promise<ApiResponse<Partner>> => {
  
  const apiResponse: ApiResponse<Partner> = {}

  const res = await fetch(`${API_URL}/partners/${id}`, {
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