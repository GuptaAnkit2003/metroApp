import axios from "axios";

const BASE_URL = "http://localhost:8080/api/tickets";

// ✅ IMPORTANT: MUST use query params
export const buyTicket = (source, destination) => {
  return axios.post(
    `${BASE_URL}/book?source=${source}&destination=${destination}`
  );
};

export const entryTicket = (id) => {
  return axios.post(`${BASE_URL}/entry/${id}`);
};

export const exitTicket = (id) => {
  return axios.post(`${BASE_URL}/exit/${id}`);
};