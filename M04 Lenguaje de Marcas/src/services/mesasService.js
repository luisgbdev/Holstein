import axios from 'axios';

const API_URL = 'http://localhost:8080'; // Asegúrate de que esta es la URL correcta para tu backend

export const getMesasDisponibles = async () => {
  try {
    const response = await axios.get(`${API_URL}/mesas`);
    return response.data;
  } catch (error) {
    console.error('Error fetching mesas disponibles:', error);
    throw error;
  }
};
