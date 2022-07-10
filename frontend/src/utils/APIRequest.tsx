import axios from "axios";
import { API_SERVER_URL } from "./Constants";

const config = {
  baseURL: API_SERVER_URL,
  headers: {
    "Access-Control-Allow-Headers": "*",
    "Access-Control-Allow-Origin": `${API_SERVER_URL}`,
    "content-Type": "application/json",
  },
};
const APIRequest = axios.create(config);

APIRequest.interceptors.request.use(async (config) => {
  const token = "";
  const customHeaders = {
    Authorization: `Bearer ${token}`,
  };

  const con = {
    ...config,
    headers: {
      ...config.headers,
      ...customHeaders,
    },
  };
  // console.log("API Request Params:" + JSON.stringify(con));
  return con;
});

APIRequest.interceptors.response.use(
  (response) => {
    // console.log("API Response:" + JSON.stringify(response));
    return response;
  },

  (error) => {
    return error.response;
  }
);

export default APIRequest;
