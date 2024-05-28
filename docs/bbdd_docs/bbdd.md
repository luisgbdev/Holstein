# M02 Bases de Datos
<<<<<<< HEAD
## WIP
### Work in progress
=======

## Proyecto Holstein: Base de Datos Relacional

En el proyecto del restaurante Holstein, especializado en carnes, hemos desarrollado una base de datos relacional utilizando MySQL. A continuación, se presenta una descripción general del diseño y la implementación de la base de datos, incluyendo la creación de tablas, procedimientos almacenados y funciones.

### Introducción

El objetivo principal de la base de datos es gestionar de manera eficiente la información relacionada con los usuarios, camareros, mesas, comandas, platos, menús y productos del restaurante Holstein. Para ello, se han creado diversas tablas relacionadas entre sí que permiten almacenar y organizar los datos de forma estructurada. Además, se han implementado procedimientos almacenados y funciones que facilitan la realización de operaciones comunes y consultas complejas.

### Creación de Tablas

Para la creación de la base de datos se ha utilizado un script SQL inicial que define las tablas principales y sus relaciones. Las tablas creadas incluyen:

- **Usuarios**: Almacena información sobre los usuarios del sistema, incluyendo su ID, nombre y rol.
- **Camareros**: Contiene datos sobre los camareros, incluyendo su ID, nombre y referencia a su usuario correspondiente.
- **Mesas**: Registra las mesas del restaurante, con su número, capacidad y el camarero asignado.
- **Comandas**: Almacena las comandas realizadas en el restaurante, vinculadas a una mesa y una fecha específica.
- **Platos**: Contiene información sobre los platos disponibles en el restaurante.
- **Menus**: Almacena los menús del restaurante.
- **Productos**: Registra los productos utilizados en la preparación de los platos.
- **ComandaPlato**: Tabla intermedia que relaciona comandas con platos, incluyendo la cantidad de cada plato en una comanda.
- **MenuPlato**: Tabla intermedia que relaciona menús con platos.
- **PlatoProducto**: Tabla intermedia que relaciona platos con productos, especificando la cantidad de cada producto necesario para preparar un plato.

### Procedimientos Almacenados

Para mejorar la funcionalidad y eficiencia del sistema, se han implementado varios procedimientos almacenados en MySQL. Estos procedimientos permiten realizar operaciones específicas de manera más eficiente. Algunos de los procedimientos creados incluyen:

- **Calcular la facturación total de un día específico**: Este procedimiento calcula la suma total de las comandas realizadas en una fecha específica.
- **Verificar la disponibilidad de una mesa en un horario específico**: Permite comprobar si una mesa está disponible en una fecha y hora dadas.
- **Calcular el salario total de un camarero en un período de tiempo específico**: Calcula el salario total de un camarero basado en un rango de fechas.
- **Verificar si un plato está agotado en el menú**: Comprueba si un plato está disponible o si se ha agotado su stock.
- **Generar un reporte de ventas por camarero en un rango de fechas**: Genera un informe de las ventas realizadas por cada camarero en un período de tiempo determinado.

### Funciones

Además de los procedimientos almacenados, se han creado varias funciones para realizar operaciones específicas dentro de la base de datos. Algunas de las funciones incluyen:

- **Visualización de mesas y camareros asignados**: Esta función devuelve un texto que muestra las mesas y los camareros asignados a cada una.
- **Registro de las comandas**: Permite registrar una nueva comanda en la base de datos.
- **Agregar un plato a la comanda**: Añade un plato específico a una comanda existente.
- **Mostrar los menús disponibles**: Devuelve un texto con los nombres de los menús disponibles en el restaurante.
- **Actualizar el stock de los productos después de hacer un plato**: Actualiza la cantidad de productos en stock después de preparar un plato.


>>>>>>> 903eda54e7e345e22abfd0d58012e0fa19dc4397
