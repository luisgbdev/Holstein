<template>
  <div class="login-container">
    <div class="background-image"></div>
    <div class="content">
      <h2 class="welcome-message">¡Bienvenido a Holstein!</h2>
      <!-- Formulario de inicio de sesión -->
      <form @submit.prevent="login" class="login-form">
        <label for="username" class="form-label">Usuario:</label>
        <input type="text" id="username" v-model="username" required class="form-input-small">
        <label for="password" class="form-label">Contraseña:</label>
        <input type="password"  id="password" v-model="password" required class="form-input-small">
        <button type="submit" class="login-button">Iniciar sesión</button>
      </form>

      <!-- Formulario de registro -->
      <h3>¿Nuevo usuario? Regístrate aquí:</h3>
      <form @submit.prevent="register" class="register-form">
        <label for="newFirstName" class="form-label">Nombre:</label>
        <input type="text" id="newFirstName" v-model="newFirstName" required class="form-input-small">
        <label for="newLastName" class="form-label">Apellido:</label>
        <input type="text" id="newLastName" v-model="newLastName" required class="form-input-small">
        <label for="newEmail" class="form-label">Email:</label>
        <input type="email" id="newEmail" v-model="newEmail" required class="form-input-small">
        <label for="newPassword" class="form-label">Nueva Contraseña:</label>
        <input type="password"  id="newPassword" v-model="newPassword" required class="form-input-small">
        <label for="confirmPassword" class="form-label">Confirmar Contraseña:</label>
        <input type="password"  id="confirmPassword" v-model="confirmPassword" required class="form-input-small">
        <!-- Contenedor para el botón de registro -->
        <div class="login-button-container">
          <button type="submit" class="login-button">Registrarse</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      newFirstName: '',
      newLastName: '',
      newEmail: '',
      newPassword: '',
      confirmPassword: ''
    };
  },
  methods: {
    login() {
      // Lógica de inicio de sesión existente
    },
    register() {
      // Implementa la lógica de registro aquí
      if (this.newPassword !== this.confirmPassword) {
        alert('Las contraseñas no coinciden. Por favor, inténtalo de nuevo.');
        return;
      }
      // Aquí puedes enviar una solicitud HTTP para registrar al usuario en el backend
      // Después de registrar al usuario, probablemente querrás redirigirlo automáticamente a la página de inicio de sesión o de inicio de sesión.
    }
  }
};
</script>
  
  
  <style scoped>
  .login-container {
    position: relative;
    min-height: 100vh;
  }
  
  .background-image {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%; 
    background-image: url('https://wallpapers.com/images/hd/cow-background-0ab0jwcnjehy2rbf.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    filter: brightness(0.5);
  }
  
  .content {
    position: relative;
    z-index: 1;
    padding: 20px;
    text-align: center;
    color: #fff;
  }
  
  .welcome-message {
    font-size: 24px;
    margin-bottom: 20px;
  }
  
  .login-form {
    margin-bottom: 20px;
  }
  
  .form-label {
    display: block;
    font-weight: bold;
    margin-bottom: 6px;
  }
  
  .form-input-small {
    width: 25%; 
    padding: 10px;
    margin-bottom: 12px;
    border: 2px solid #fff;
    border-radius: 4px;
    font-size: 14px;
    color: #333;
    background-color: rgba(255, 255, 255, 0.8); 
    width: 50%;
  }
  
  .login-button {
    width: 50%;
    padding: 13px;
    background-color: #9acd32;
    color: #fff;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s ease;
    font-size: 14px;
    width: 50%;
  }
  
  .login-button:hover {
    background-color: #7fbf26; /* Color verde claro más oscuro al pasar el ratón */
  }
  
  .signup-message {
    font-size: 14px;
  }
  
  .signup-link {
    color: #9acd32; /* Color verde claro */
    text-decoration: none;
  }
  
  .signup-link:hover {
    text-decoration: underline;
  }
  .register-button-container {
  text-align: center;
  margin-top: 20px; /* Espacio superior entre los campos del formulario y el botón */
}
  </style>