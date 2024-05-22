<template>
  <div id="app">
    <!-- Aquí se renderizará el componente correspondiente al enrutamiento -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      isAuthenticated: false, // Estado de autenticación
    };
  },
  created() {
    // Llama a una función para verificar la autenticación al cargar la aplicación
    this.checkAuth();
  },
  methods: {
    // Función para verificar la autenticación
    checkAuth() {
      // Aquí iría tu lógica para verificar si el usuario está autenticado
      // Por ejemplo, puedes verificar si hay un token de sesión o si el usuario está almacenado en localStorage
      const token = localStorage.getItem('token');
      if (token) {
        // Si hay un token, el usuario está autenticado
        this.isAuthenticated = true;
      }
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

