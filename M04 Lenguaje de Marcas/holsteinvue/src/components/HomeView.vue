<template>
    <div>
      <!-- Botón de menú fijo -->
      <div class="menu-btn-fixed" @click="toggleMenu">
        <img src="@/assets/tres lineas.png" alt="Menú">
      </div>
  
      <!-- Menú lateral -->
      <nav class="sidebar" :class="{ 'active': isMenuOpen }">
        <ul>
          <li><a href="#platos" @click="toggleMenu">Platos</a></li>
          <li><a href="#menus" @click="toggleMenu">Menús</a></li>
          <li><a href="#exoticos" @click="toggleMenu">Platos Exóticos</a></li>
          <li><a href="#reservas" @click="toggleMenu">Reservas</a></li>
        </ul>
      </nav>
  
      <!-- Contenido principal -->
      <div class="content">
        <!-- Título del restaurante centrado en la imagen de fondo -->
        <header class="background-image">
          <h1>HOLSTEIN</h1>
        </header>
  
        <!-- Información de los platos -->
        <div id="platos" class="platos-container">
          <h2>Nuestros Platos</h2>
          <div class="platos-list">
            <div v-for="(plato, index) in platos" :key="index" class="plato-card">
              <img :src="plato.imagen" :alt="plato.nombre">
              <div class="plato-info">
                <h3>{{ plato.nombre }}</h3>
                <p>{{ plato.descripcion }}</p>
              </div>
            </div>
          </div>
        </div>
  
        <!-- Separación para los menús -->
        <div class="menu-separator"></div>
  
        <!-- Información de los menús -->
        <div id="menus" class="menus-container">
          <h2>Nuestros Menús</h2>
          <div class="menu-list">
            <div v-for="(menu, index) in menus" :key="index" class="menu-card">
              <h3>{{ menu.nombre }}</h3>
              <p><strong>Precio:</strong> {{ menu.precio }}€ por {{ menu.tipo }}</p>
              <p><strong>Descripción:</strong> {{ menu.descripcion }}</p>
            </div>
          </div>
        </div>
  
        <!-- Separación para los platos exóticos -->
        <div class="menu-separator"></div>
  
        <!-- Información de los platos exóticos -->
        <div id="exoticos" class="exoticos-container">
          <h2>Platos Exóticos</h2>
          <div class="exoticos-list">
            <div v-for="(plato, index) in platosExoticos" :key="index" class="plato-card">
              <img :src="plato.imagen" :alt="plato.nombre">
              <div class="plato-info">
                <h3>{{ plato.nombre }}</h3>
                <p>{{ plato.descripcion }}</p>
              </div>
            </div>
          </div>
        </div>
  
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        isMenuOpen: false,
        platos: [
          // Plato 1
          {
            nombre: 'Filete de ternera',
            descripcion: 'Exquisito filete de ternera a la parrilla, sazonado con hierbas frescas y servido con una guarnición de verduras frescas, que incluyen zanahorias, brócoli y champiñones. Este plato es perfecto para los amantes de la carne que buscan una experiencia gourmet',
            imagen: require('@/assets/filete_ternera.jpg')
          },
          // Plato 2
          {
            nombre: 'Chuletas de cerdo',
            descripcion: 'Jugosas chuletas de cerdo a la parrilla, marinadas en una salsa especial y acompañadas de un puré de patatas cremoso y suave. Este plato es una opción reconfortante y satisfactoria para cualquier ocasión.',
            imagen: require('@/assets/chuletas_cerdo.jpg')
          },
          // Plato 3
          {
            nombre: 'Pollo asado',
            descripcion: 'Tierna pechuga de pollo asada a la perfección, sazonada con hierbas aromáticas y acompañada de una deliciosa ensalada fresca y arroz blanco. Este plato es una opción saludable y sabrosa para cualquier comida.',
            imagen: require('@/assets/pollo_asado.jpg')
          },
          // Plato 4
          {
            nombre: 'Chuletas de cerdo',
            descripcion: ' Jugosas chuletas de cerdo a la parrilla, marinadas en una salsa especial y acompañadas de un puré de patatas cremoso y suave. Este plato es una opción reconfortante y satisfactoria para cualquier ocasión.',
            imagen: require('@/assets/chuletas_cerdo.jpg')
          },
          // Plato 5
          {
            nombre: 'Entrecot',
            descripcion: 'Jugoso entrecot a la parrilla, sazonado con nuestra exclusiva mezcla de especias y servido con champiñones salteados, un puré de patatas cremoso y una generosa porción de nuestra salsa chimichurri casera. Este plato es una delicia para los amantes de la carne y seguramente satisfará cualquier antojo.',
            imagen: require('@/assets/entrecot.jpg')
          },
          // Plato 6
          {
            nombre: 'Churrasco',
            descripcion: 'Experimenta la auténtica experiencia argentina con nuestro churrasco, tierno y jugoso, marinado en una mezcla de hierbas y especias tradicionales y servido con papas fritas recién cortadas. El toque final lo pone nuestra salsa chimichurri casera, que realza el sabor de la carne y te transporta directamente a las pampas argentinas.',
            imagen: require('@/assets/churrasco.jpg')
          },
          // Plato 7
          {
            nombre: 'Pechuga de pollo',
            descripcion: 'Nuestra pechuga de pollo a la plancha es la opción perfecta para aquellos que buscan una comida saludable y deliciosa. Acompañada de arroz cocido al vapor y una fresca ensalada de hojas verdes, esta opción ligera es ideal para una comida equilibrada y satisfactoria.',
            imagen: require('@/assets/pechuga_pollo.jpg')
          },
          // Plato 8
          {
            nombre: 'Bife de chorizo',
            descripcion: 'Sumérgete en la deliciosa experiencia de nuestro bife de chorizo, jugoso y lleno de sabor, acompañado de papas a la crema. Este plato es una combinación perfecta de sabores y texturas que te dejará completamente satisfecho.',
            imagen: require('@/assets/bife.jpg')
          },
          // Plato 9
          {
            nombre: 'Parrillada mixta',
            descripcion: 'Disfruta de una fiesta de sabores con nuestra parrillada mixta, que incluye una variedad de carnes exquisitamente preparadas, como chorizo, morcilla y entraña, acompañadas de una selección de salsas caseras y guarniciones. Esta opción es perfecta para aquellos que desean probar un poco de todo.',
            imagen: require('@/assets/parrillada.jpg')
          },
          // Plato 10
          {
            nombre: 'Hamburguesa de res',
            descripcion: ' Nuestra hamburguesa de carne de res se sirve en un pan recién horneado y está rellena con una jugosa hamburguesa de carne de res, queso derretido, crujiente lechuga, rodajas de tomate fresco y cebolla caramelizada, todo rematado con nuestra salsa secreta especial. Esta hamburguesa es una verdadera delicia que deleitará a tu paladar en cada bocado.',
            imagen: require('@/assets/hamburguesa.jpg')
          },
        ],
        menus: [
          {
            nombre: 'Menu del día',
            precio: 10,
            tipo: 'individual',
            descripcion: 'Incluye plato principal, acompañamiento y bebida.'
          },
          {
            nombre: 'Menu especial',
            precio: 20,
            tipo: 'individual',
            descripcion: 'Incluye plato principal, entrada, postre y bebida.'
          },
          {
            nombre: 'Menu infantil',
            precio: 8,
            tipo: 'infantil',
            descripcion: 'Incluye plato principal, acompañamiento, postre y juguete.'
          }
        ],
        platosExoticos: [
          {
            nombre: 'Filete de avestruz',
            descripcion: 'Deléitate con un exquisito filete de avestruz a la parrilla, con un centro tierno y jugoso y un exterior ligeramente crujiente. Acompañado de un cremoso puré de batata y boniato, este plato te transportará a tierras lejanas y exóticas.',
            imagen: require('@/assets/filete_avestruz.jpg')
          },
          {
            nombre: 'Medallones de canguro',
            descripcion: 'Descubre el sabor único de los medallones de canguro, cocidos a la perfección y cubiertos con una deliciosa salsa de frutos rojos que aporta un equilibrio entre lo dulce y lo ácido. Este plato exótico te sorprenderá con su ternura y su exquisito sabor.',
            imagen: require('@/assets/medallones_canguro.jpg')
          },
          {
            nombre: 'Pinchos de caimán',
            descripcion: 'Prueba la aventura culinaria de los pinchos de caimán a la parrilla, marinados en una salsa picante que despierta tus sentidos y te hace sentir la emoción de la selva. Cada bocado te transportará a un mundo de sabores exóticos y emocionantes.',
            imagen: require('@/assets/pinchos_caiman.jpg')
          },
          {
            nombre: 'Carne de cebra asada',
            descripcion: 'Disfruta de la autenticidad africana con nuestra carne de cebra asada, tierna y sabrosa, acompañada de unas patatas bravas crujientes y una salsa picante que realza su sabor. Este plato te llevará en un viaje culinario a las vastas llanuras africanas.',
            imagen: require('@/assets/cebra_asada.webp')
          },
          {
            nombre: 'Búfalo a la parrilla',
            descripcion: 'Sumérgete en la tradición culinaria de las llanuras americanas con nuestro búfalo a la parrilla, bañado en una salsa barbacoa casera. Cada bocado es una experiencia salvaje y deliciosa que te conecta con la naturaleza.',
            imagen: require('@/assets/bufalo_parrilla.jpg')
          },
          {
            nombre: 'Filete de ñandú',
            descripcion: 'Explora los sabores exóticos de Sudamérica con nuestro filete de ñandú a la parrilla, servido sobre una fresca ensalada de quinoa con unas piezas de aguacate, un limón para el aliño y pimientos frescos. Este plato ligero y sabroso es una opción saludable y deliciosa para cualquier ocasión.',
            imagen: require('@/assets/filete_nandu.jpg')
          },
        ]
      };
    },
    methods: {
      toggleMenu() {
        this.isMenuOpen = !this.isMenuOpen;
      }
    }
  };
  </script>
  
  
  <style scoped>
  /* Estilos para el botón de menú fijo */
  .menu-btn-fixed {
    position: fixed;
    top: 20px;
    left: 20px;
    cursor: pointer;
    z-index: 1200;
  }
  
  .menu-btn-fixed img {
    width: 30px;
  }
  
  /* Estilos para el menú lateral */
  .sidebar {
    position: fixed;
    top: 0;
    left: 0;
    width: 250px;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
    transition: transform 0.3s ease;
    transform: translateX(-250px);
    z-index: 1300; /* Ajusta el z-index para que el menú lateral esté por encima del fondo */
  }
  
  .sidebar.active {
    transform: translateX(0);
  }
  
  .sidebar ul {
    list-style-type: none;
    padding: 0;
    margin-top: 50px;
  }
  
  .sidebar ul li {
    padding: 15px;
  }
  
  .sidebar ul li a {
    color: white;
    text-decoration: none;
    font-size: 1.2rem;
  }
  
  .sidebar ul li a:hover {
    background-color: rgba(255, 255, 255, 0.2);
  }
  
  /* Estilos para el contenido */
  .content {
    margin-left: 250px; /* Ajusta el margen izquierdo para dejar espacio al menú lateral */
  }
  
  /* Estilos para las cartas de los platos */
  .plato-card {
    width: calc(33.33% - 20px); /* Para tener tres columnas con margen entre ellas */
    margin-bottom: 20px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    overflow: hidden;
  }
  
  .plato-card img {
    width: 100%;
    height: auto;
  }
  
  .plato-info {
    padding: 20px;
  }
  
  .plato-info h3 {
    margin-top: 0;
  }
  
  .plato-info p {
    color: #666;
  }
  
  .platos-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  /* Estilos para la imagen de fondo */
  .background-image {
    background-image: url('https://media.disneylandparis.com/d4th/es-es/images/n034297_2025sep08_world_cowboy-cookout-barbecue-restaurant-food-on-site_16-9_tcm797-254889.jpg?w=1960');
    background-size: cover;
    background-position: center;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    position: relative; /* Ajusta el posicionamiento para que el z-index funcione */
    z-index: 1200; /* Ajusta el z-index para que el menú lateral esté por debajo del fondo */
  }
  
  .background-image h1 {
    color: white;
    font-size: 3em;
  }
  
  /* Estilos para la separación entre platos y menús */
  .menu-separator {
    margin-top: 50px;
    border-top: 2px solid #ccc;
  }
  
  /* Estilos para las cartas de los menús */
  .menu-card {
    width: 50%;
    margin: 20px auto;
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }
  
  .menu-card h3 {
    margin-top: 0;
  }
  
  .menu-card p {
    color: #666;
  }
  
  /* Estilos para las cartas de los platos exóticos */
  .exoticos-container .exoticos-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
  
  .exoticos-container .plato-card {
    width: calc(33.33% - 20px); /* Para tener tres columnas con margen entre ellas */
    margin-bottom: 20px;
  }
  
  h2 {
    text-align: center; /* Centra el texto */
    margin-top: 50px; /* Añade un espacio superior */
    margin-bottom: 40px; /* Añade un espacio inferior */
  }
  </style>