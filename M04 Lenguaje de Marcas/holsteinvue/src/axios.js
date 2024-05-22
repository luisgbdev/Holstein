import axios from 'axios';

// Configura la URL base para todas las peticiones
const instance = axios.create({
  baseURL: 'http://localhost:3000/api' // Cambia esto según sea necesario
});

export default instance;